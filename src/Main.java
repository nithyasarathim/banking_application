import java.io.IOException;
import java.sql.SQLException;

import controller.BankController;
import exception.BankingException;
import exception.InvalidAccountTypeException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException
	{
		BankController bc =new BankController();
		bc.start();
	}
}
