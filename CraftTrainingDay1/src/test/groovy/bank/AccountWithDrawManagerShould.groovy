package bank

import spock.lang.Specification

class AccountWithDrawManagerShould extends Specification {

	private AccountWithDrawManager withdrawManager;
	def "withdraw given amount"() {
		given:
			TransactionRepository repository = Mock();
			withdrawManager = new AccountWithDrawManager(repository);
			def amount = 100;
		when:	
			withdrawManager.withdraw(amount);
		then:
			1 * repository.withdrawTransation(amount)
	} 
}
