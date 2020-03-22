/**
 * this class represent the location of the Property objects and the areas they occupy
 * @author Jiaxi Tang
 *
 */
public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	/**
	 * no-arg constructor
	 * x and y are set to zero
	 * depth and width are set to 1
	 */
	public Plot()
	{
		x=0;
		y=0;
		depth = 1;
		width = 1;
	}
	
	/**
	 * copy constructor
	 * @param p Plot object
	 */
	public Plot(Plot p)
	{
		this.x = p.x;
		this.y = p.y;
		this.depth = p.depth;
		this.width = p.width;
	}
	
	/**
	 * Parameterized constructor
	 * @param x x coordinate of the upper left corner of the property
	 * @param y y coordinate of the upper left corner of the property
	 * @param width width of the property
	 * @param depth length(vertical) of the property
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	/**
	 * this method determines if this plot overlaps the parameter plot
	 * @param plot another plot
	 * @return true if they overlap, false otherwise
	 */
	public boolean overlaps(Plot plot)
	{
		boolean bool = false;
		//check if this plot's x domain contain parameter plot's x domain
		if((this.x>=plot.x && this.x<=(plot.x+plot.width)) || 
				((this.x+this.width)>=plot.x && (this.x+this.width)<=(plot.x+plot.width)) ||
				(this.x<=plot.x && (plot.x+plot.width)<=(this.x+this.width)) || 
				(this.x>=plot.x && (plot.x+plot.width)>=(this.x+this.width)))
		{
			//check if this plot's y domain contain parameter plot's y domain
			if((this.y>plot.y && this.y<(plot.y+plot.depth)) ||
					((this.y+this.depth)>plot.y && (this.y+this.depth)<(plot.y+plot.depth)) ||
					(this.y<=plot.y && (plot.y+plot.depth)<=(this.y+this.depth)) || 
					(this.y>=plot.y && (plot.y+plot.depth)>=(this.y+this.depth)))
			{
				//check if the plot are just sharing same side or not
				if(!(this.y<=plot.y && (this.y+this.depth)<=plot.y)||
						!(this.y>=(plot.y+plot.depth) && (this.y+this.depth)>=(plot.y+plot.depth)))
					bool = true;
			}
		}
		return bool;
	}
	
	/**
	 * this method determines if this plot encompass the parameter plot
	 * @param plot plot object
	 * @return true if the parameter plot is encompassed, false otherwise
	 */
	public boolean encompasses(Plot plot)
	{
		boolean bool1 = false, bool2 = false;
		if((plot.x+plot.width) <= (this.x+this.width) && plot.x >= this.x)
			bool1 = true;
		if((plot.y+plot.depth) <= (this.y+this.depth) && plot.y >= this.y)
			bool2 = true;
		boolean bool = bool1 && bool2;
		return bool;
	}

	/**
	 * set x
	 * @param x x coordinate of the upper left corner of the property
	 */
	public void setX(int x)
	{
		this.x=x;
	}

	/**
	 * set y
	 * @param y y coordinate of the upper left corner of the property
	 */
	public void setY(int y)
	{
		this.y=y;
	}

	/**
	 * set width
	 * @param width width of the plot
	 */
	public void setWidth(int width)
	{
		this.width=width;
	}

	/**
	 * set depth
	 * @param depth length(vertical) of the plot
	 */
	public void setDepth(int depth)
	{
		this.depth=depth;
	}

	/**
	 * get x
	 * @return x coordinate of the upper left corner of the property
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * get y
	 * @return y coordinate of the upper left corner of the property
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * get width 
	 * @return width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * get depth
	 * @return length(vertical) of the plot
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "Upper left: ("+this.x+","+this.y+"); Width: "+this.width+" Depth: "+this.depth;
	}
}
