
public class Television {
	private final String MANUFACTURER;// hold the brand name
	private final int SCREEN_SIZE; // hold the size of the television's screen size
	private boolean powerOn; // if the power is on, hold true value; if the power is off, hold false value 
	private int channel, volume; // hold the number of station, and of the volume 
	
	// constructor which set values to the fields
	public Television(String brand, int size)
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerOn = false;
		channel = 2;
		volume =20;
	}
	
	/**
	 * This method set the channel
	 * @param channel it holds the value of the channel
	 */
	public void setChannel(int channel)
	{
		this.channel = channel;
	}
	
	/**
	 * This method will toggle the power between on and off
	 * If the power is on, it will become off after this method is called
	 * If the power is off, it will become on after this method is called
	 */
	public void power()
	{
		powerOn = !powerOn;
	}
	
	/**
	 * This method increase the volume by one
	 */
	public void increaseVolume()
	{
		this.volume++;
	}
	
	/**
	 * This method decrease the volume by one
	 */
	public void decreaseVolume()
	{
		this.volume--;
	}
	
	/**
	 * This method return the value of the volume
	 * @return the value of volume
	 */
	public int getVolume()
	{
		return volume;
	}
	
	/**
	 * This method return the value of the channel
	 * @return the value of channel
	 */
	public int getChannel()
	{
		return channel;
	}
	
	/**
	 * This method return the value of the size of screen
	 * @return the value of size of the screen
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	
	/**
	 * This method return the value of the size of screen
	 * @return the value of size of the screen
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
}
