import java.io.IOException;
import java.sql.SQLException;

import controller.BankController;
import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException, UpdateFailureException, DeleteAccountException
	{
		BankController bc =new BankController();
		bc.start();
	}
}
