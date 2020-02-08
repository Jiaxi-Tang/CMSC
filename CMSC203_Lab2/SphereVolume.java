import java.util.Scanner;

public class SphereVolume 
{
	public static void main(String[] args)
	{
		double diam;
		Scanner in = new Scanner(System.in);
		System.out.println("This program is used to find the volume of a sphere.");
		System.out.println("Enter the diameter of the sphere: ");
		diam = in.nextDouble();
		double r = diam/2;
		double v = ((double)4/3) * Math.PI * Math.pow(r, 3);
		System.out.println("The volume of the solid is "+v);
		in.close();
	}
}
