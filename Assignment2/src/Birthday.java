import javax.swing.JOptionPane;
import java.util.Random;
//program description: This program is a driver program for toy class, which provide information about toys. This program ask user for
//  						their choice of toys and display the total cost of the toys
//programmer: Jiaxi Tang
//Date: 2/22/2020

public class Birthday{

	public static void main(String[] args) {
		String name, cont = "yes", answ = "yes", yn, randStr;
		Toy toy = new Toy();
		double cost = 0;
		int random;
		JOptionPane.showMessageDialog(null, "Birthday Program (Programmer: Jiaxi)");
		JOptionPane.showMessageDialog(null, "Welcome to Toy company\nchoose the toy for your child!!");
		//main body of the program, don't exit until the user enter no
		while (cont.toLowerCase().charAt(0)=='y')
		{
			name = getInformation(toy);
			//check if the toy is age appropriate for the child
			while(!toy.ageOK() && answ.toLowerCase().charAt(0)=='y')
			{
				answ = JOptionPane.showInputDialog("The toy you choose isn't age-appropriate for your child.\n"
						+ "Do you want to cancel this toy request? (y or n)");
				if (answ.toLowerCase().charAt(0)=='y')
				{
					name = getInformation(toy);
				}
			}
			JOptionPane.showMessageDialog(null, "Good choice");
			toy.setCost(toy.getToy());
			yn = JOptionPane.showInputDialog("Do you want a card with your toy? (yes or no)");
			toy.addCard(yn);
			yn = JOptionPane.showInputDialog("Do you want a ballon with your toy? (yes or no)");
			toy.addBalloon(yn);
			cost += toy.getCost();
			JOptionPane.showMessageDialog(null, "The toy for " + name + toy);
			cont = JOptionPane.showInputDialog("Do you want to continue?");
		}
		Random num = new Random();
		random = num.nextInt(100000);
		//formatting the random number displayed to make it always have 5 digits
		randStr = String.format("%05d", random);
		//display total cost
		JOptionPane.showMessageDialog(null, "Total cost of your order: $"+String.format("%.2f", cost)+"\nOrder number: "
				+randStr+"\nProgrammer:"
				+ "Jiaxi Tang");
	}
	// This method ask user for the information about the child, and return the child's name
	public static String getInformation(Toy toy)
	{
		String name = JOptionPane.showInputDialog("What's the child's name?");
		toy.setAge(Integer.parseInt(JOptionPane.showInputDialog("What's the child's age?")));
		toy.setToy(JOptionPane.showInputDialog("Choose a toy for your child: plushie, blocks, or a book"));
		//check if the user enter the name of the toy correctly
		while(toy.getToy().equals(""))
		{
			JOptionPane.showMessageDialog(null, "The toy you choosed isn't in our provided list.");
			toy.setToy(JOptionPane.showInputDialog("Choose a toy for your child: plushie, blocks, or a book"));
		}
		return name;
	}
}
