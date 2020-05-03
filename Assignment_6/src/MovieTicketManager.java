import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class manage ticket class and all of its subclasses
 * @author Jiaxi Tang
 *
 */
public class MovieTicketManager implements MovieTicketManagerInterface{
	private ArrayList<Ticket> tickets;
	private ArrayList<String> employeeMovieList = new ArrayList<String>();
	private ArrayList<MoviePass> moviePassList = new ArrayList<MoviePass>();
	
	/**
	 * no-arg constructor
	 */
	public MovieTicketManager()
	{
		tickets = new ArrayList<Ticket>();
	}
	
	@Override
	/**
	 * @return number of times the one with this id visit this theater
	 */
	public int numVisits(int id) {
		int count =0;
		for(Ticket t : tickets)
		{
			if(t.getId()==id)
				count++;
		}
		return count;
	}

	@Override
	/**
	 * @return number of times the one with this id see this movie
	 */
	public int numThisMovie(int id, String movie) {
		int count=0;
		for(Ticket t : tickets)
		{
			if(t.getId()==id && t.getMovie().equals(movie))
				count++;
		}
		return count;
	}

	@Override
	/**
	 * @return number of times the one with this id visit this theater on the provided date
	 */
	public int numMoviesToday(int id, int date) {
		int count =0;
		for(Ticket t : tickets)
		{
			if(t.getId()==id && t.getDay()==date)
				count++;
		}
		return count;
	}

	@Override
	/**
	 * add the tickets
	 */
	public double addTicket(String movie, String rating, int day, int time, String type, String customer, int id) {
		customer = customer.toLowerCase();
		switch(customer)
		{
		case "adult":
			Ticket a = new Adult(movie, rating, day, time, type);
			tickets.add(a);
			break;
		case "child":
			Ticket b = new Child(movie, rating, day, time, type);
			tickets.add(b);
			break;
		case "employee":
			employeeMovieList.add(""+id);
			Ticket c = new Employee(movie, rating, day, time, type, id, employeeMovieList);
			tickets.add(c);
			break;
		case "moviepass":
			moviePassList.add(new MoviePass(movie, rating, day, time, type, id));
			Ticket d = new MoviePass(movie, rating, day, time, type, id, moviePassList);
			tickets.add(d);
			break;
		default:
			return -1;
		}
		return tickets.get(tickets.size()-1).getPrice();
	}

	@Override
	/**
	 * @return total sales this month
	 */
	public double totalSalesMonth() {
		double sales = 0;
		for( Ticket t : tickets)
		{
			sales += t.getPrice();
		}
		return sales;
	}

	@Override
	/**
	 * @return monthly sales report
	 */
	public String monthlySalesReport() {
		double sales = totalSalesMonth();
		int a_count=0, c_count =0, e_count=0, m_count=0;
		double a_sales = 0, c_sales =0, e_sales=0, m_sales=0;
		for(Ticket t : tickets)
		{
			if(t instanceof Adult)
			{
				a_count++;
				a_sales += t.getPrice();
			}
			else if(t instanceof Child)
			{
				c_count++;
				c_sales +=t.getPrice();
			}
			else if(t instanceof Employee)
			{
				e_count++;
				e_sales+=t.getPrice();
			}
			else if(t instanceof MoviePass)
			{
				m_count++;
				m_sales += t.getPrice();
			}
		}
		
		String str = "Monthly Sales Report\n\n"
				+"\t\tSales Number\n "
				+"ADULT\t"+a_sales+"   "+a_count
				+"\nCHILD\t"+c_sales+"   "+c_count
				+"\nEMPLOYEE\t"+e_sales+" "+e_count
				+"\nMOVIEPASS\t"+m_sales+" "+m_count+"\n\n"
				+"Total monthly sales: $"+sales;
		return str;
	}

	@Override
	/**
	 * return sorted-by-date arrayList with only 3d tickets
	 */
	public ArrayList<String> get3DTickets() {
		// in order by date
		ArrayList<Ticket> temp = new ArrayList<Ticket>();
		Ticket compare_3d = new Adult("","",1,1,"3D");
		for(Ticket t : tickets)
		{
			if(t.getType().equals(compare_3d.getType()))
					temp.add(t);
		}
		temp = sort_by_date(temp);
		ArrayList<String> str = new ArrayList<String>();
		for(Ticket t : temp)
		{
			str.add(t.toString());
		}
		return str;
	}

	@Override
	/**
	 * return sorted-by-date arrayList with all tickets
	 */
	public ArrayList<String> getAllTickets() {
		// in order by date
		ArrayList<Ticket> temp = new ArrayList<Ticket>();
		for(Ticket t : tickets)
		{
			temp.add(t);
		}
		temp = sort_by_date(temp);
		ArrayList<String> str = new ArrayList<String>();
		for(Ticket t : temp)
		{
			str.add(t.toString());
		}
		return  str;
	}

	@Override
	/**
	 * return sorted-by-id arrayList with only moviepass tickets
	 */
	public ArrayList<String> getMoviePassTickets() {
		// in order by id
		ArrayList<Ticket> temp = new ArrayList<Ticket>();
		for(Ticket t : tickets)
		{
			if(t instanceof MoviePass)
					temp.add(t);
		}
		temp = sort_by_id(temp);
		ArrayList<String> str = new ArrayList<String>();
		for(Ticket t : temp)
		{
			str.add(t.toString());
		}
		return str;
	}

	@Override
	/**
	 * read in files to add tickets
	 */
	public void readFile(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String every = "";
		while(in.hasNext())
		{
			every+=in.nextLine();
			every+="\n";
		}
		String[] strArr = every.split("\n");
		String[] temp;
		for( int i =0; i< strArr.length; i++)
		{
			temp = strArr[i].split(":");
			//addTicket(String movie, String rating, int day, int time, String type, String customer, int id)
			addTicket(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], Integer.parseInt(temp[6]));
		}
		in.close();
	}
	
	/**
	 * sorting-by-date method
	 * @param t Arraylist of Ticket class
	 * @return sorted arraylist
	 */
	public ArrayList<Ticket> sort_by_date(ArrayList<Ticket> t)
	{
		int minIndex = 0;
		Ticket s;
		for(int i =0; i <t.size(); i++)
		{
			minIndex =i;
			for(int j =i; j<t.size(); j++)
			{
				if(t.get(minIndex).getDay()>t.get(j).getDay())
					minIndex = j;
			}
			s = t.get(minIndex);
			t.set(minIndex,t.get(i));
			t.set(i, s);
		}
		return t;
	}
	
	/**
	 * sorting-by-id method
	 * @param t Arraylist of Ticket class
	 * @return sorted arraylist
	 */
	public ArrayList<Ticket> sort_by_id(ArrayList<Ticket> t)
	{
		int minIndex = 0;
		Ticket s;
		for(int i =0; i <t.size(); i++)
		{
			minIndex =i;
			for(int j =i; j<t.size(); j++)
			{
				if(t.get(minIndex).getId()>t.get(j).getId())
					minIndex = j;
			}
			s = t.get(minIndex);
			t.set(minIndex,t.get(i));
			t.set(i, s);
		}
		return t;
	}
	
	/**
	 * clear arraylists with employee information
	 */
	public void clearEList()
	{
		employeeMovieList = new ArrayList<String>();
	}
	
	/**
	 * clear arraylists with employee information
	 */
	public void clearMList()
	{
		moviePassList = new ArrayList<MoviePass>();
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		ArrayList<String> str = getAllTickets();
		String str1="";
		for(String l : str) {
			str1 += l+"\n";
		}
		return str1;
	}
}
