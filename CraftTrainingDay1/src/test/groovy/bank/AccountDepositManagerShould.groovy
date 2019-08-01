package bank

import spock.lang.Specification

class AccountDepositManagerShould extends Specification {

	private AccountDepositManager depositManager;
	def "desposit given amount"() {
		given:
			TransactionRepository repository = Mock();
			depositManager = new AccountDepositManager(repository);
			def amount = 100;
		when:	
			depositManager.deposit(amount);
		then:
			1 * repository.depositTransation(amount)
	} 
}
