package controller;

import service.AccountService;

public class BankController {
	
	private final AccountService accountService;

	public BankController() {
		super();
		this.accountService = new AccountService();
	}
	
	boolean running =true;
	public void start() {
		while(running)
		{
			displayMenu();
		}
	}
	
	public void displayMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("------------BANKING APPLICATION-------------");
		System.out.println("--------------------------------------------");
		System.out.println("1. CREATE ACCOUNT---------------------------");
		System.out.println("0. EXIT-------------------------------------");
		
		
	}
	
}
