package bank

import spock.lang.Specification

class TransactionRepositoryShould extends Specification {

	private TransactionRepository repository;
	
	def "deposit transaction into respository"() {
		given:
			repository = new TransactionRepository()
			repository.clearTransactions();
			def amount = 100;
		when:
			def txId = repository.depositTransation(amount)
		then:
			txId == repository.getLastInsertedTxId()
	}
	
	def "deposit multiple transactions into respository"() {
		given:
			repository = new TransactionRepository()
			repository.clearTransactions();
			def amount = 100;
			repository.depositTransation(amount)
			def txId2 = repository.depositTransation(amount)
			def lastTxId;
		when:
			lastTxId = repository.getLastInsertedTxId();
		then:
			txId2 == lastTxId
	}
	
	def "return valid balance after multiple deposit transactions"() {
		given:
			repository = new TransactionRepository()
			repository.clearTransactions();
			repository.depositTransation(100)
			repository.depositTransation(200)
		when:
			def returnedBalance = repository.getBalance();
		then:
			returnedBalance == 300
	}
	
	def "withdraw transaction from respository"() {
		given:
			repository = new TransactionRepository()
			repository.clearTransactions();
			repository.depositTransation(1000)
		when:
			def remainingBalance = repository.withdrawTransation(500)
		then:
			remainingBalance == 500
	}
	
	def "get all transactions in reverse chronological order"() {
		given:
			repository = new TransactionRepository()
			repository.clearTransactions();
			repository.depositTransation(1000)
			repository.depositTransation(2000)
			repository.withdrawTransation(3000)
		when:
			def transactions = repository.getTransacations()
		then:
			transactions.get(0).getAmount() == 3000 
			transactions.get(1).getAmount() == 2000
			transactions.get(2).getAmount() == 1000
	}
	
}
