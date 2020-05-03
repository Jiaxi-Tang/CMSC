import java.util.ArrayList;

/**
 * this class represent moviepass ticket type
 * @author Administrator
 *
 */
public class MoviePass extends Ticket{
	private int Id;

	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 * @param Id id of the movie pass
	 */
	public MoviePass(String movie, String rating, int day, int time, String type, int Id)
	{
		super(movie, rating, day, time, type);
		this.Id = Id;
	}
	
	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 * @param Id id of the movie pass
	 * @param moviePassList list recording the information of all moviepasses
	 */
	public MoviePass(String movie, String rating, int day, int time, String type, int Id, ArrayList<MoviePass> moviePassList)
	{
		super(movie, rating, day, time, type);
		this.Id = Id;
		super.setPrice(calculateTicketPrice(moviePassList));
	}

	/**
	 * calculate ticket price
	 * @param moviePassList list recording the information of all moviepasses
	 * @return ticket price
	 */
	public double calculateTicketPrice(ArrayList<MoviePass> moviePassList) {
		double price;
		int day_count=0, movie_count=0,type_count=0;
		ArrayList<MoviePass> temp = new ArrayList<MoviePass>();
		for(MoviePass m : moviePassList)
		{
			if(m.getId()==this.Id)
				temp.add(m);
		}

		for(MoviePass m : temp)
		{
			if(this.getDay()==m.getDay())
				day_count++;
			if(this.getMovie().equals(m.getMovie()))
				movie_count++;
			if(this.getType().equals(Format.IMAX) || this.getType().equals(Format.Three_D))
			{
				type_count++;
			}
		}
		if(day_count==1 && movie_count ==1 && type_count== 0 && temp.size()==1)
			return 9.99;
		if(day_count==1 && movie_count ==1 && type_count== 0)
			return 0;
		if(super.getTime()<18)
			price = 10.5;
		else
			price = 13.5;

		if(super.getType().equals(Format.IMAX))
			price +=3;
		else if(super.getType().equals(Format.Three_D))
			price +=2.5;

		price *=1.096;
		return price;
	}

	@Override
	/**
	 * return movie pass id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * toString method
	 */
	public String toString()
	{
		return "MoviePass "+ Id + " " + super.toString();
	}


	@Override
	/**
	 * method not used
	 * @return 0
	 */
	public double calculateTicketPrice() {
		return 0;
	}
}
