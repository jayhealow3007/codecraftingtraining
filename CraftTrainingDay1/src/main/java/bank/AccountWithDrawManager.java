package bank;

public class AccountWithDrawManager {

	private final TransactionRepository repository;
	
	public AccountWithDrawManager(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public void withdraw(int amount) {
		this.repository.withdrawTransation(amount);
	}
}
