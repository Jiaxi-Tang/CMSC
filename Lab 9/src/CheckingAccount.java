
public class CheckingAccount extends BankAccount {
	private static final double FEE = 0.15;
	public CheckingAccount(String name, double amount) {
		super(name,amount);
		String str = super.getAccountNumber();
		str +="-10";
		super.setAccountNumber(str);
	}
	
	public boolean withdraw(double amount) {
		return super.withdraw(amount+FEE);
	}
	
	
}
