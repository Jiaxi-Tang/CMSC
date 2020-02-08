import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) 
	{
		System.out.println("Wind Chill Calculator\n");
		final double CON1 = 35.74, CON2 = 0.6215, CON3 = 35.75, CON4 = 0.4275;
		double windSpeed, temp, windChill;
		Scanner in = new Scanner(System.in);
		//prompt the user to enter the values
		System.out.println("Enter wind speed in MPH, between 5 and 60 inclusive: ");
		windSpeed = in.nextDouble();
		System.out.println("Enter temperature in Fahrenheit, between -45 and 40 inclusive: ");
		temp = in.nextDouble();
		//Wind Chill (oF) = 35.74 + 0.6215T - 35.75(V^0.16) + 0.4275T(V^0.16), t = temperature, v = wind speed
		//windChill = CON1 + CON2 * temp - CON3 * windspeed ^ 0.16 + CON4 * temp * (windspeed ^ 0.16)
		windChill = CON1 + CON2 * temp - CON3 * Math.pow(windSpeed,0.16) + CON4 
				* temp * Math.pow(windSpeed, 0.16);
		System.out.println("The wind chill temperature is: " + windChill);
		System.out.println("Programmer: Jiaxi Tang");
		in.close();
	}

}
