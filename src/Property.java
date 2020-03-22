/**
 * this class represent each individual property
 * @author Jiaxi Tang
 *
 */
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * no-arg constructor
	 * city, owner, and propertyName is set to empty string
	 * rentAmount is set to 0
	 * plot is defined as default plot
	 */
	public Property()
	{
		city = "";
		owner = "";
		propertyName = "";
		rentAmount =0;
		plot = new Plot();
	}
	
	/**
	 * copy constructor
	 * @param p Property object
	 */
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	/**
	 * parameterized constructor
	 * plot is defined as default plot
	 * @param propertyName name of the property
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner name of the owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * parameterized constructor
	 * @param propertyName name of the property
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner name of the owner
	 * @param x x coordinate of the upper left corner of the property
	 * @param y y coordinate of the upper left corner of the property
	 * @param width width of the property
	 * @param depth length(vertical) of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * set the Plot object
	 * @param x x coordinate of the upper left corner of the property
	 * @param y y coordinate of the upper left corner of the property
	 * @param width width of the property
	 * @param depth length(vertical) of the property
	 * @return the Plot object
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot = new Plot(x, y, width, depth);
		return plot;
	}

	/**
	 * set the city name
	 * @param city name of the city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * set the name of the owner
	 * @param owner name of the owner
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	/**
	 * set the name of the property
	 * @param propertyName name of the property
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}

	/**
	 * set the rent amount
	 * @param rentAmount rent amount
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}

	/**
	 * get the name of the city
	 * @return name of the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * get the name of the owner
	 * @return name of the owner
	 */
	public String getOwner()
	{
		return owner;
	}

	/**
	 * get the name of the property
	 * @return name of the property
	 */
	public String getPropertyName()
	{
		return propertyName;
	}

	/**
	 * get the rent amount
	 * @return rent amount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}

	/**
	 * get the plot attribue of the Property object
	 * @return the Plot object
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		String str="Property name: "+propertyName+"\n";
		str += " Located in "+city+"\n";
		str += " Belongs to "+owner+"\n";
		str += " Rent amount: "+rentAmount+"";
		return str;
	}
}
