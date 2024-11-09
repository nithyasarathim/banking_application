import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import controller.BankController;
import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import exception.UpdateFailureException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException, BankingException, UpdateFailureException, DeleteAccountException, InterruptedException, ExecutionException, InvalidTransactionAmountException, TransactionFailureException
	{
		BankController bc =new BankController();
		bc.start();
	}
}
