
/**
 * This class represent Adult ticket
 * @author Jiaxi Tang
 *
 */
public class Adult extends Ticket{
	
	/**
	 * parameterized constructor
	 * @param movie the name of the movie
	 * @param rating the rating of the movie
	 * @param day the day of the movie, from 1 ~ 31
	 * @param time the time of the movie, from 8 ~ 23
	 * @param type the type of the movie, 3d, imax or none
	 */
	public Adult(String movie, String rating, int day, int time, String type)
	{
		super(movie, rating, day, time, type);
		super.setPrice(calculateTicketPrice());
	}
	
	@Override
	/**
	 * calculate the ticket price
	 */
	public double calculateTicketPrice() {
		double price;
		if(super.getTime()<18)
			price = 10.5;
		else
			price = 13.5;
		
		if(super.getType().equals(Format.IMAX))
			price+=3;
		else if(super.getType().equals(Format.Three_D))
			price+=2.5;
		
		price *= 1.096;
		return price;
	}

	@Override
	/**
	 * return -1 as the id
	 */
	public int getId() {
		return -1;
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "Adult "+super.toString();
	}

}
