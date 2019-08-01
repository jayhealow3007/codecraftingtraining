package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TransactionRepository {
	
	private Map<Integer, Transaction> transactions = new LinkedHashMap<>();
	
	public int depositTransation(int amount) {
		Transaction transaction = prepareTransaction(amount, Transaction.DEPOSIT);
		int id = transactions.size() + 1;
		transactions.put(id, transaction);
		return id;
	}
	
	public int getLastInsertedTxId() {
		return transactions.size();
	}
	
	public void clearTransactions() {
		transactions.clear();
	}
	
	public int getBalance() {
		int balance = 0;
		Iterator<Entry<Integer, Transaction>> transactionsItr = transactions.entrySet().iterator();
		while (transactionsItr.hasNext()) {
			Map.Entry<Integer, Transaction> entry = transactionsItr.next();
			if(entry.getValue().getType() == Transaction.DEPOSIT) {
				balance += entry.getValue().getAmount(); 
			} else {
				balance -= entry.getValue().getAmount();
			}
			
		}
		return balance;
	}

	public int withdrawTransation(int amount) {
		Transaction transaction = prepareTransaction(amount, Transaction.WITHDRAW);
		transactions.put(transactions.size() + 1, transaction);
		return getBalance();
	}
	
	public List<Transaction> getTransacations() {
		List<Transaction> transactionsList = new ArrayList<>();
		Iterator<Transaction> transactionsItr = transactions.values().iterator();
		while (transactionsItr.hasNext()) {
			Transaction transaction = transactionsItr.next();
			transactionsList.add(transaction);
		}
		Collections.reverse(transactionsList); 
		return transactionsList;
	}

	private Transaction prepareTransaction(int amount, int transactionType) {
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDate(new DateGenerator().getDate());
		transaction.setType(transactionType);
		if(transactionType == Transaction.DEPOSIT) {
			transaction.setBalance(getBalance() + amount);
		} else {
			transaction.setBalance(getBalance() - amount);
		}
		return transaction;
	}
}
