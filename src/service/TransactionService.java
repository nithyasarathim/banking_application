package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import dao.TransactionDAO;
import dao.TransactionDAOimpl;
import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import utility.TransactionHistoryUtil;

public class TransactionService {
	private final TransactionDAO transactionDAO;
	private final ExecutorService executorService;
	
	public TransactionService() {
		this.transactionDAO=new TransactionDAOimpl();
		this.executorService = Executors.newFixedThreadPool(5);
	}
	public Future<?> deposit (int accountId, double amount)
	{
		return executorService.submit(() -> {
			try {
				transactionDAO.deposit(accountId,amount);
				TransactionHistoryUtil.saveTransaction("DEPOSIT", accountId, amount);
			}
			catch(InvalidTransactionAmountException | SQLException | TransactionFailureException |IOException e) {
				System.err.println("Error during deposit :"+e.getMessage());
			} 
		});
		
	}
}

