/**
 * This class represents a management company, including functions of
 * showing every properties inside the company's management territory,
 * finding the property with maximum rent, and
 * find the total rent amount
 * @author Jiaxi Tang
 *
 */
public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	/**
	 * no-arg constructor, set mgmFeePer to 0, and name and taxID to empty string
	 * management company's plot is defined as default plot with depth and width equal to 10
	 * properties array is deined here
	 */
	public ManagementCompany()
	{
		mgmFeePer = 0;
		name = "";
		properties = new Property[MAX_PROPERTY];
		taxID = "";
		plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Parameterized constructor, 
	 * management company's plot is defined as default plot with depth and width equal to 10
	 * properties array is deined here
	 * @param name name of the management company
	 * @param taxID tax ID of the management company
	 * @param mgmFeePer management fee percentage 
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY]; 
	}
	
	/**
	 * Parameterized constructor, 
	 * management company's plot is defined by the information passed in
	 * properties array is deined here
	 * @param name name of the company
	 * @param taxID tax ID of the company
	 * @param mgmFeePer management fee percentage
	 * @param x x coordinate of the upper left corner of the company's management territory
	 * @param y y coordinate of the upper left corner of the company's management territory
	 * @param width width of the company's management territory
	 * @param depth length(vertical) of the company's management territory
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY]; 
	}
	
	/**
	 * copy constructor
	 * @param otherCompany another ManagementCompany object
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
		for(int i =0; i<MAX_PROPERTY; i++)
		{
			this.properties[i]= new Property(otherCompany.properties[i]);
		}
	}
	
	/**
	 * This method check if the properties array is full, the Property object is null, 
	 * and if the the property is inside the management company plot,
	 * and if the Property object overlaps the other property
	 * @param p property object being checked
	 * @param ps array of property objects
	 * @return -1 if properties array is full, -2 if Property object is null, 
	 * 		   -3 if the property isn't inside the management company plot,
	 * 		   -4 if the property overlaps the others.		
	 */
	private int checkProperty(Property p, Property[] ps)
	{
		int count =0;
		for(int i =0; i<MAX_PROPERTY; i++)
		{
			if(ps[i]==null)
				count ++;
		}
		if(count == 0)
			return -1;
		if(p==null)
			return -2;
		if(!plot.encompasses(p.getPlot()))
			return -3;
		for(Property p1 : ps)
		{
			if(p1 != null && p.getPlot().overlaps(p1.getPlot()))
				return -4;
		}
		return 0;
	}
	
	/**
	 * add property to the properties array by using already existed Property object
	 * @param property Property object
	 * @return index where the Property object is stored
	 */
	public int addProperty(Property property)
	{
		if(checkProperty(property, properties)<0)
			return checkProperty(property, properties);
		int index = 0;
		for(int i=0; i<MAX_PROPERTY; i++)
		{
			if(properties[i]==null)
			{
				properties[i]=new Property(property);
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * add property to the properties array by using parameters
	 * @param name name of the Property
	 * @param city city where the property is located
	 * @param rent rent amount 
	 * @param owner name of the owner
	 * @return index where the Property object is stored
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		if(checkProperty(property, properties)<0)
			return checkProperty(property, properties);
		int index = 0;
		for(int i=0; i<MAX_PROPERTY; i++)
		{
			if(properties[i]==null)
			{
				properties[i]=property;
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * add property object to properties array using parameters
	 * @param name name name of the Property
	 * @param city city where the property is located
	 * @param rent rent amount 
	 * @param owner name of the owner
	 * @param x  x coordinate of the upper left corner of the property
	 * @param y y coordinate of the upper left corner of the property
	 * @param width width of the property
	 * @param depth depth of the property
	 * @return index where the property object is stored
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		if(checkProperty(property, properties)<0)
			return checkProperty(property, properties);
		int index = 0;
		for(int i=0; i<MAX_PROPERTY; i++)
		{
			if(properties[i]==null)
			{
				properties[i]=property;
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * return MAX_PROPERTY
	 * @return maximum property that's allowed to be stored in properties array
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	/**
	 * this method return the index where the Property with maximum rent is located
	 * @return index where the Property with maximum rent is located
	 */
	public int maxRentPropertyIndex() 
	{
		double rent = properties[0].getRentAmount();
		int index =0;
		for(int i = 0; i<MAX_PROPERTY;i++)
		{
			Property p1 = properties[i];
			if(p1!=null && p1.getRentAmount()>rent)
			{
				rent = p1.getRentAmount();
				index = i;
			}
		}
		return index;
	}
	/**
	 * this method return the maximum rent amount 
	 * @return the maximum rent amount
	 */
	public double maxRentProp()
	{
		return properties[maxRentPropertyIndex()].getRentAmount();
	}
	
	/**
	 * this method return total rent amount
	 * @return total rent amount
	 */
	public double totalRent()
	{
		double rent = 0;
		for(Property p1 : properties)
		{
			if(p1!=null)
				rent += p1.getRentAmount();
		}
		return rent;
	}
	
	/**
	 * this method display information of a property locates at index i of the properties array
	 * @param i index of the properties array
	 * @return String containing information about the Property object
	 */
	public String displayPropertyAtIndex(int i)
	{
		String str = properties[i].toString();
		return str;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		String str = "List of Properties for "+name+", taxID: "+taxID+"\n";
		str += "__________________________________________________________________\n";
		for(Property p1 : properties)
		{
			str += p1;
			str +="\n";
		}
		str += "__________________________________________________________________\n";
		str += "Total management fee: "+(totalRent()*mgmFeePer*0.01);
		return str;
	}
}
