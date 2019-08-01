package bank

import spock.lang.Shared
import spock.lang.Specification

class AccountServiceFeature extends Specification {

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
		
	def "should print a statement"() {
		given:
			console = Mock()
			AccountService service = new AccountService(repository, depositManager, withdrawManager, console);
			service.deposit(1000)
			service.withdraw(1000)
			service.deposit(2000)
		when:
			service.printStatement()
		then:
			1 * console.print("DATE|AMOUNT|BALANCE")
		then:
			1 * console.print("03/01/2019|2000|2000")
		then:
			1 * console.print("02/01/2019|-1000|0")
		then:
			1 * console.print("01/01/2019|1000|1000")
		 	
	}
}
