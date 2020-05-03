/**
 * This program serve as a super class for other types of tickets
 * @author Jiaxi Tang
 *
 */
public abstract class Ticket {
	protected enum Format {IMAX, Three_D, NONE}
	private Format type;
	private int day, time;
	private String rating, movie;
	private double price;
	
	/**
	 * No-arg constructor
	 */
	public Ticket(){
		type = Format.NONE;
		day = 0;
		time = 0;
		rating = "";
		movie = "";
		price = 0;
	}
	
	/**
	 * Instantiate the object by using the parameters
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 */
	public Ticket(String movie, String rating, int day, int time, String type) {
		if(type.toLowerCase().equals("imax"))
		{
			this.type = Format.IMAX;
		}
		else if(type.toLowerCase().equals("3d"))
		{
			this.type = Format.Three_D;
		}
		else
			this.type = Format.NONE;
		this.day = day;
		this.time = time;
		this.rating = rating;
		this.movie = movie;
	}
	
	/**
	 * abstract class for calculating ticket price
	 * @return ticket price
	 */
	public abstract double calculateTicketPrice();
	/**
	 * abtract class for getting id
	 * @return id 
	 */
	public abstract int getId();
	
	/**
	 * return the type of the movie -- imax, 3d or none 
	 * @return type of the movie
	 */
	public Format getType()
	{
		return type;
	}
	
	/**
	 * set the type of the movie -- imax, 3d or none 
	 * @param type type of the movie
	 */
	public void setType(Format type)
	{
		this.type = type;
	}
	
	/**
	 * return the day of the movie from 1 ~ 31
	 * @return the day of the movie
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * set the day of the movie from 1 ~ 31
	 * @param day the day of the movie
	 */
	public void setDay(int day)
	{
		this.day = day;
	}
	
	/**
	 * get the time of the movie from 8 ~ 23
	 * @return the time of the movie
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * set the time of the movie from 8 ~ 23
	 * @param time the time of the movie
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	
	/**
	 * get the rating of the movie -- G, PG, PG13, R, or NR.
	 * @return the rating of the movie
	 */
	public String getRating()
	{
		return rating;
	}
	
	/**
	 * set the rating of the movie -- G, PG, PG13, R, or NR.
	 * @param rating the rating of the movie
	 */
	public void setRating(String rating)
	{
		this.rating = rating;
	}
	
	/**
	 * get the name of the movie
	 * @return the name of the movie
	 */
	public String getMovie()
	{
		return movie;
	}
	
	/**
	 * set the name of the movie
	 * @param movie the name of the movie
	 */
	public void setMovie(String movie)
	{
		this.movie = movie;
	}
	
	/**
	 * get the price of the ticket 
	 * @return price of the ticket
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * set price of the ticket
	 * @param price price of the ticket
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return movie+" "+type+" $"+price+" Day:"+ day+" Time:"+time;
	}
}
