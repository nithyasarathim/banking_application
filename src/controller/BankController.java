package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import exception.BankingException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Bank;
import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountService;
import service.BankService;

public class BankController {
	
	private final AccountService accountService;
	private final BankService bankService;
	private final BufferedReader br;

	public BankController() {
		super();
		this.accountService = new AccountService();
		this.bankService = new BankService();
		this.br =new BufferedReader (new InputStreamReader(System.in));
	}
	
	boolean running =true;
	public void start() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException, UpdateFailureException {
		while(running)
		{
			displayMenu();
			int choice = Integer.parseInt(br.readLine());
			
			switch (choice)
			{
			case 1:
			{
				createAccount();
				break;
			}
			case 2:
			{
				updateAccount();
			}
			}
		}
	}
	
	private void createAccount() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException {
		System.out.println("\n");
		
		System.out.println("ENTER CUSTOMER ID						 :");
		int cusID = Integer.parseInt(br.readLine());
		
		System.out.println("ENTER BANK ID							 :");
		int bankID = Integer.parseInt(br.readLine());
		Bank bank =bankService.getBankById(bankID);
		
		System.out.println("ENTER ACCOUNT TYPE (SAVINGS / CURRENT)   :");
		String accountType =br.readLine();
		
		System.out.println("ENTER THE BALANCE						 :");
		double bal = Double.parseDouble(br.readLine());
		
		if("Savings".equalsIgnoreCase(accountType)){
			System.out.println("ENTER INTEREST RATE						 :");
			double interest=Double.parseDouble(br.readLine());
			accountService.createAccount(new SavingsAccount(0,cusID,bank,accountType,bal,interest));
		}
		else if("Current".equalsIgnoreCase(accountType)) {
			System.out.println("ENTER OVERDRAFT LIMIT					 :");
			double overdraftlimit=Double.parseDouble(br.readLine());
			accountService.createAccount(new CurrentAccount(0,cusID,accountType,bank,bal,overdraftlimit));
		}
		else {
			System.out.println("-------< INVALID ACCOUNT TYPE >-------");
		}
	}
	
	private void updateAccount() throws SQLException, NumberFormatException, IOException, BankingException, UpdateFailureException{
		System.out.println("\n");
		System.out.println("ENTER CUSTOMER ID TO UPDATE				:");
		int cusID = Integer.parseInt(br.readLine());
		
		System.out.println("ENTER UPDATED BANK ID					:");
		int bankID = Integer.parseInt(br.readLine());
		Bank bank =bankService.getBankById(bankID);
		
		System.out.println("ENTER ACCOUNT TYPE (SAVINGS / CURRENT)  :");
		String accountType =br.readLine();
		
		System.out.println("ENTER THE UPDATED BALANCE				:");
		double bal = Double.parseDouble(br.readLine());
		
		if("Savings".equalsIgnoreCase(accountType)) {
			System.out.println("ENTER UPDATED INTEREST RATE 		:");
			double interest=Double.parseDouble(br.readLine());
			accountService.updateAccount(new SavingsAccount(0,cusID,bank,accountType,bal,interest));
		}
		else if("Current".equalsIgnoreCase(accountType)){
			System.out.println("ENTER UPDATED OVERDRAFT LIMIT		:");
			double overdraftlimit=Double.parseDouble(br.readLine());
			accountService.updateAccount(new CurrentAccount(0,cusID,accountType,bank,bal,overdraftlimit));
		}
		
	}

	public void displayMenu() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|----------| BANKING APPLICATION |-----------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("|---- 1-       CREATE ACCOUNT            ----|");
		System.out.println("|---- 2-       UPDATE ACCOUNT            ----|");
		System.out.println("|---- 0-       EXIT                      ----|");
		System.out.println("|--------------------------------------------|");
		System.out.println("|-------<< 	  ENTER YOUR CHOICE    >>--------|");
		System.out.println("|--------------------------------------------|");
		
	}
	
}
