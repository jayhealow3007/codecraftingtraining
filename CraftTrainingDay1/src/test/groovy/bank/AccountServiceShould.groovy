package bank

import spock.lang.Shared
import spock.lang.Specification

class AccountServiceShould extends Specification {
	
	private AccountService service;
	
	@Shared TransactionRepository repository
	@Shared AccountDepositManager depositManager
	@Shared AccountWithDrawManager withdrawManager
	@Shared Console console

	def setup() {
		console = new Console()
		repository = new TransactionRepository()
		depositManager = new AccountDepositManager(repository)
		withdrawManager = new AccountWithDrawManager(repository)
	}

	def "deposit the amount"() {
		given:
			def amount = 1000;
			depositManager = Mock()
			service = new AccountService(repository, depositManager, withdrawManager, console);
		when:
			service.deposit(amount);
		then:
			1 * depositManager.deposit(amount)
	}
	
	def "withdraw the amount"() {
		given:
			def amount = 1000;
			withdrawManager = Mock()
			service = new AccountService(repository, depositManager, withdrawManager, console);
		when:
			service.withdraw(amount);
		then:
			1 * withdrawManager.withdraw(amount)
	}
}
