
/**
 * this class represent child ticket
 * @author Jiaxi Tang
 *
 */
public class Child extends Ticket{

	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 */
	public Child(String movie, String rating, int day, int time, String type)
	{
		super(movie, rating, day, time, type);
		super.setPrice(calculateTicketPrice());
	}
	
	@Override
	/**
	 * calculate ticket price
	 */
	public double calculateTicketPrice() {
		double price=0;
		if(super.getTime()<18)
			price = 5.75;
		else
			price = 10.75;
		
		if(super.getType().equals(Format.IMAX))
			price+=2;
		else if(super.getType().equals(Format.Three_D))
			price+=1.5;
		
		price *=1.096;
		return price;
	}

	@Override
	/**
	 * return -1 as id
	 */
	public int getId() {
		return -1;
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "Child " + super.toString();
	}
}
