package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.BankingException;
import exception.DeleteAccountException;
import exception.InvalidAccountTypeException;
import exception.UpdateFailureException;
import model.Account;
import utility.DBconnection;

public class AccountDAOimpl implements AccountDAO {

	@Override
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException {
		
		String sql="INSERT INTO ACCOUNT (customer_id, bank_id, account_type, balance) VALUES (?,?,?,?)";
		
		try (Connection con= DBconnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
				
				ps.setInt(1, account.getCustomer_id());
				ps.setInt(2, account.getBank().getBank_id());
				ps.setString(3, account.getAccount_type());
				ps.setDouble(4,account.getBalance());
				
				int result =ps.executeUpdate();
				if(result == 0){
					throw new InvalidAccountTypeException ("Account Type not recognized");
				}
		}			
	}

	@Override
	public void updateAccount(Account account) throws SQLException, UpdateFailureException {
		
		String sql="UPDATE ACCOUNT SET bank_id=?, account_type=?,balance=? WHERE customer_id=?";
		
		try (Connection con=DBconnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
			
			ps.setInt(1, account.getBank().getBank_id());
			ps.setString(2,account.getAccount_type());
			ps.setDouble(3,account.getBalance());
			ps.setInt(4, account.getCustomer_id());
			
			int result =ps.executeUpdate();
			if(result == 0) {
				throw new UpdateFailureException("Update Failure");
			}
		}
	}

	@Override
	public void deleteAccount(int cusID) throws SQLException, DeleteAccountException{
		
		String sql="DELETE FROM ACCOUNT WHERE customer_id=?";
		
		try(Connection con=DBconnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
			
			ps.setInt(1, cusID);
			
			int result =ps.executeUpdate();
			if(result == 0) {
				throw new DeleteAccountException("No user found with that ID");
			}
		}
	}
	
	
	


}
