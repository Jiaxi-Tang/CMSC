import java.util.ArrayList;

/**
 * this class represent employee ticket
 * @author Jiaxi Tang
 *
 */
public class Employee extends Ticket{
	private int Id, times;
	
	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 * @param Id id of the employee
	 * @param employeeMovieList list of employees which records the id of employees who have go to this theater
	 */
	public Employee(String movie, String rating, int day, int time, String type, int Id, ArrayList<String> employeeMovieList)
	{
		super(movie, rating, day, time, type);
		this.Id = Id;
		super.setPrice(calculateTicketPrice(true, employeeMovieList));
	}
	
	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 * @param Id id of the employee
	 * @param times how many times has this employee watch movie in this theater
	 */
	public Employee(String movie, String rating, int day, int time, String type, int Id, int times)
	{
		super(movie, rating, day, time, type);
		this.Id = Id;
		this.times = times+1;
		super.setPrice(calculateTicketPrice());
	}
	
	@Override
	/**
	 * method used to calculate ticket price when the number of times the employee watch movie in this theater is provided
	 * @return the ticket price
	 */
	public double calculateTicketPrice() {
		if(times <=2)
			return 0;
		
		double price;
		if(super.getTime()<18)
			price = 10.5;
		else
			price = 13.5;
		
		if(super.getType().equals(Format.IMAX))
			price+=3;
		else if(super.getType().equals(Format.Three_D))
			price+=2.5;
		
		price /= 2;
		price *= 1.096;
		return price;
	}

	/**
	 * method used to calculate ticket price when the number of times the employee watch movie in this theater isn't provided
	 * @param i parameter used to indicate this method
	 * @param employeeMovieList list of employees which records the id of employees who have go to this theater
	 * @return the ticket price
	 */
	public double calculateTicketPrice(boolean i, ArrayList<String> employeeMovieList)
	{
		int count=0;
		for(String str : employeeMovieList)
		{
			String tempId = ""+this.Id;
			if(tempId.equals(str))
			{
				count++;
			}
		}
		if(count<=2)
			return 0;
		
		double price;
		if(super.getTime()<18)
			price = 10.5;
		else
			price = 13.5;
		
		if(super.getType().equals(Format.IMAX))
			price+=3;
		else if(super.getType().equals(Format.Three_D))
			price+=2.5;
		
		price /= 2;
		price *= 1.096;
		return price;
	}
	
	@Override
	/**
	 * return employee id
	 */
	public int getId() {
		return Id;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "Employee "+ Id + " " + super.toString();
	}

}
