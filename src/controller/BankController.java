package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import exception.UpdateFailureException;
import model.Bank;
import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountService;
import service.BankService;
import service.TransactionService;

public class BankController {
	
	private final AccountService accountService;
	private final BankService bankService;
	private final BufferedReader br;
	private final TransactionService transactionService;

	public BankController() {
		super();
		this.accountService = new AccountService();
		this.bankService = new BankService();
		this.transactionService = new  TransactionService();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	boolean running = true;
	public void start() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException, UpdateFailureException, DeleteAccountException, InterruptedException, ExecutionException, InvalidTransactionAmountException, TransactionFailureException {
		while(running) {
			displayMenu();
			int choice = Integer.parseInt(br.readLine());
			
			switch (choice) {
			case 0:
				running = false;
				transactionService.shutDownExecutorService();
				break;
			case 1:
				createAccount();
				break;
			case 2:
				updateAccount();
				break;
			case 3:
				deleteAccount();
				break;
			case 4:
				viewAccount();
				break;
			case 5:
				deposit();
				break;
			case 6:
				withdraw();
				break;
			default:
				System.out.println("Invalid choice, please try again!");
			}
		}
	}
	
	private void createAccount() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException {
		System.out.println("\n------------------------------------");
		System.out.println("CREATE ACCOUNT");
		System.out.println("------------------------------------");

		System.out.print("Enter Customer ID: ");
		int cusID = Integer.parseInt(br.readLine());

		System.out.print("Enter Bank ID: ");
		int bankID = Integer.parseInt(br.readLine());
		Bank bank = bankService.getBankById(bankID);
		
		System.out.print("Enter Account Type (SAVINGS / CURRENT): ");
		String accountType = br.readLine();
		
		System.out.print("Enter Balance: ");
		double bal = Double.parseDouble(br.readLine());
		
		if("Savings".equalsIgnoreCase(accountType)) {
			System.out.print("Enter Interest Rate: ");
			double interest = Double.parseDouble(br.readLine());
			accountService.createAccount(new SavingsAccount(0, cusID, bank, accountType, bal, interest));
		} else if("Current".equalsIgnoreCase(accountType)) {
			System.out.print("Enter Overdraft Limit: ");
			double overdraftLimit = Double.parseDouble(br.readLine());
			accountService.createAccount(new CurrentAccount(0, cusID, accountType, bank, bal, overdraftLimit));
		} else {
			System.out.println("------- < INVALID ACCOUNT TYPE > -------");
		}
	}
	
	private void updateAccount() throws SQLException, NumberFormatException, IOException, BankingException, UpdateFailureException {
		System.out.println("\n------------------------------------");
		System.out.println("UPDATE ACCOUNT");
		System.out.println("------------------------------------");

		System.out.print("Enter Customer ID to Update: ");
		int cusID = Integer.parseInt(br.readLine());

		System.out.print("Enter Updated Bank ID: ");
		int bankID = Integer.parseInt(br.readLine());
		Bank bank = bankService.getBankById(bankID);
		
		System.out.print("Enter Account Type (SAVINGS / CURRENT): ");
		String accountType = br.readLine();
		
		System.out.print("Enter Updated Balance: ");
		double bal = Double.parseDouble(br.readLine());
		
		if("Savings".equalsIgnoreCase(accountType)) {
			System.out.print("Enter Updated Interest Rate: ");
			double interest = Double.parseDouble(br.readLine());
			accountService.updateAccount(new SavingsAccount(0, cusID, bank, accountType, bal, interest));
		} else if("Current".equalsIgnoreCase(accountType)) {
			System.out.print("Enter Updated Overdraft Limit: ");
			double overdraftLimit = Double.parseDouble(br.readLine());
			accountService.updateAccount(new CurrentAccount(0, cusID, accountType, bank, bal, overdraftLimit));
		} else {
			System.out.println("------- < INVALID ACCOUNT TYPE > -------");
		}
	}
	
	private void deleteAccount() throws NumberFormatException, IOException, SQLException, DeleteAccountException {
		System.out.println("\n------------------------------------");
		System.out.println("DELETE ACCOUNT");
		System.out.println("------------------------------------");

		System.out.print("Enter Customer ID to Delete: ");
		int cusID = Integer.parseInt(br.readLine());
		accountService.deleteAccount(cusID);
	}
	
	private void viewAccount() throws NumberFormatException, IOException, SQLException {
		System.out.println("\n------------------------------------");
		System.out.println("VIEW ACCOUNT DETAILS");
		System.out.println("------------------------------------");

		System.out.print("Enter Account ID to View: ");
		int accID = Integer.parseInt(br.readLine());
		accountService.viewAccount(accID);
	}
	
	private void deposit() throws NumberFormatException, IOException, InterruptedException, ExecutionException {
		System.out.println("\n------------------------------------");
		System.out.println("DEPOSIT");
		System.out.println("------------------------------------");

		System.out.print("Enter Account ID: ");
		int id = Integer.parseInt(br.readLine());

		System.out.print("Enter the Amount to be Deposited: ");
		double amount = Double.parseDouble(br.readLine());

		Future<?> future = transactionService.deposit(id, amount);
		future.get();
	}
	
	private void withdraw() throws NumberFormatException, IOException, InvalidTransactionAmountException, SQLException, TransactionFailureException, InterruptedException, ExecutionException {
		System.out.println("\n------------------------------------");
		System.out.println("WITHDRAW");
		System.out.println("------------------------------------");
		
		System.out.println("Enter Account ID: ");
		int id = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the Amount to be Withdrawed: ");
		double amount = Double.parseDouble(br.readLine());
		
		Future<?> future = transactionService.withdraw(id, amount);
		future.get();
	}
	

	public void displayMenu() {
		System.out.println("\n--------------------------------------------");
		System.out.println("|---------- BANKING APPLICATION ----------|");
		System.out.println("--------------------------------------------");
		System.out.println("| 1. CREATE ACCOUNT                       |");
		System.out.println("| 2. UPDATE ACCOUNT                       |");
		System.out.println("| 3. DELETE ACCOUNT                       |");
		System.out.println("| 4. VIEW ACCOUNT DETAILS                 |");
		System.out.println("| 5. DEPOSIT                              |");
		System.out.println("| 6. WITHDRAW                             |");
		System.out.println("| 0. EXIT                                 |");
		System.out.println("--------------------------------------------");
		System.out.print("Enter your choice: ");
	}
}
