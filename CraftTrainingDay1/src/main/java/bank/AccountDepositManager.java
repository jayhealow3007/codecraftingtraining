package bank;

public class AccountDepositManager {
	
	private final TransactionRepository repository;
	
	public AccountDepositManager(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public void deposit(int amount) {
		this.repository.depositTransation(amount);
	}

}
