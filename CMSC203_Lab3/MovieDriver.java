import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args)
	{
		Movie movie = new Movie();
		Scanner in = new Scanner(System.in);
		String cont ="y";
		while(cont.charAt(0)=='y')
		{
			System.out.println("Enter the name of the movie: ");
			movie.setTitle(in.nextLine());
			System.out.println("Enter the rating of the movie: ");
			movie.setRating(in.nextLine());
			System.out.println("Enter the number of tickets sold of the movie: ");
			movie.setSoldTickets(in.nextInt());
			System.out.println(movie);
			System.out.println("Do you want to continue (y or n)?: ");
			in.nextLine();
			cont = in.nextLine();
		}
		in.close();
	}
}
