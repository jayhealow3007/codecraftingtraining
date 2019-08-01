package bank;

public class Transaction {

	public static final int DEPOSIT = 1;
	public static final int WITHDRAW = 2;
	
	private String date;
	private int type;
	private int amount;
	private int balance;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [date=");
		builder.append(date);
		builder.append(", type=");
		builder.append(type);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", balance=");
		builder.append(balance);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
