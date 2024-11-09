package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import utility.DBconnection;

public class TransactionDAOimpl implements TransactionDAO {

	@Override
	public synchronized void deposit(int accountID, double amount) throws InvalidTransactionAmountException, SQLException, TransactionFailureException {
		if(amount<=0) {
			throw new InvalidTransactionAmountException("deposit amount should be valid");
		}
		try(Connection con=DBconnection.getConnection())
		{
			CallableStatement st=con.prepareCall("{CALL DEPOSIT(?,?)");
			st.setInt(1, accountID);
			st.setDouble(2, amount);
			st.execute();
		}
		catch(SQLException e)
		{
			throw new TransactionFailureException("Deposit Failed :"+e.getMessage());
		}

	}

	@Override
	public synchronized void withdraw(int accountID, double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public  synchronized void transfer(int fromAccount, int toAccount, double amount) {
		// TODO Auto-generated method stub

	}

}
