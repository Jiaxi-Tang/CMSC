
public class test {
public static void main(String[] args)
{
	MovieTicketManager ticketList = new MovieTicketManager();
	ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","Employee",12345);
	ticketList.addTicket("Action Point", "NR", 2,12,"NONE","Employee",23456);
	ticketList.addTicket("Book Club", "PG13", 1,13,"IMAX","Employee",45678);
	System.out.print(ticketList.monthlySalesReport());
}
}
