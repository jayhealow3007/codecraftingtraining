package bank;

import java.util.Collection;
import java.util.Iterator;

public class AccountService {

	private AccountDepositManager depositManager;
	private AccountWithDrawManager withdrawManager;
	private TransactionRepository repository;
	private Console console;
	
	public AccountService(TransactionRepository repository, AccountDepositManager depositManager, AccountWithDrawManager withdrawManager, Console console) {
		this.repository = repository;
		this.depositManager = depositManager;
		this.withdrawManager = withdrawManager;
		this.console = console;
	}
	
	public void deposit(int amount) {
		this.depositManager.deposit(amount);
	}
	
	public void withdraw(int amount) {
		this.withdrawManager.withdraw(amount);
	}
	
	public void printStatement() {
		Collection<Transaction> transactions = this.repository.getTransacations();
		Iterator<Transaction> transactionsItr = transactions.iterator();
		this.console.print("DATE | AMOUNT | BALANCE");
		while (transactionsItr.hasNext()) {
			Transaction transaction = transactionsItr.next();
			StringBuilder builder = new StringBuilder();
			builder.append(transaction.getDate());
			builder.append(transaction.getAmount());
			builder.append(transaction.getBalance());
			this.console.print(builder.toString());
		}
	}
	
}
