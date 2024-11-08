package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountService;

public class BankController {
	
	private final AccountService accountService;
	private final BufferedReader br;

	public BankController() {
		super();
		this.accountService = new AccountService();
		this.br =new BufferedReader (new InputStreamReader(System.in));
	}
	
	boolean running =true;
	public void start() throws NumberFormatException, IOException {
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
			}
		}
	}
	
	private void createAccount() throws NumberFormatException, IOException {
		System.out.println("\n");
		System.out.println("ENTER CUSTOMER ID						 :");
		int cusID = Integer.parseInt(br.readLine());
		System.out.println("ENTER BANK ID							 :");
		int bankID = Integer.parseInt(br.readLine());
		System.out.println("ENTER ACCOUNT TYPE (SAVINGS / CURRENT)   :");
		String accountType =br.readLine();
		System.out.println("ENTER THE BALANCE						 :");
		double bal = Double.parseDouble(br.readLine());
		
		if("Savings".equalsIgnoreCase(accountType)){
			System.out.println("ENTER INTEREST RATE						 :");
			double interest=Double.parseDouble(br.readLine());
			accountService.createAccount(new SavingsAccount(0,cusID,,accountType,bal,interest));
		}
		else if("Current".equalsIgnoreCase(accountType)) {
			System.out.println("ENTER OVERDRAFT LIMIT					 :");
			double overdraftlimit=Double.parseDouble(br.readLine());
			accountService.createAccount(new CurrentAccount(0,cusID,,accountType,bal,overdraftlimit));
		}
		else {
			System.out.println("---------< INVALID ACCOUNT TYPE >---------")
		}
		
		
		
	}

	public void displayMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("------------BANKING APPLICATION-------------");
		System.out.println("--------------------------------------------");
		System.out.println("---- 1-    CREATE ACCOUNT               ----");
		System.out.println("---- 0-    EXIT                         ----");
		System.out.println("--------------------------------------------");
		System.out.println("--------<< 	 ENTER YOUR CHOICE	 >>---------");
		System.out.println("--------------------------------------------");
		
	}
	
}
