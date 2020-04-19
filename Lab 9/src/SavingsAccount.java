
public class SavingsAccount extends BankAccount{
	private double rate = 0.025;
	private int savingsNumber =0;
	String accountNumber;
	
	public SavingsAccount(String name, double amount) {
		super(name,amount);
		accountNumber = super.getAccountNumber() +"-"+savingsNumber;
		savingsNumber++;
	}
	
	public SavingsAccount(SavingsAccount old, double amount) {
		super(old,amount);
		String str = old.getAccountNumber();
		savingsNumber++;
		str = str.substring(0,str.length()-2)+"-"+savingsNumber;
		accountNumber = str;
	}
	
	public void postInterest() {
		super.setBalance(super.getBalance()+super.getBalance()*(rate/12));
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
}
