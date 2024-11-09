package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			else
			{
				System.out.println("\nUPDATION SUCCESS !\n");
			}
		}
	}

	@Override
	public void deleteAccount(int accID) throws SQLException, DeleteAccountException{
		
		String sql="DELETE FROM ACCOUNT WHERE account_id=?";
		
		try(Connection con=DBconnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
			
			ps.setInt(1, accID);
			
			int result =ps.executeUpdate();
			if(result == 0) {
				throw new DeleteAccountException("No account found with that ID");
			}
			else
			{
				System.out.println("\n DELETION SUCCESS \n");
			}
		}
	}

	@Override
	public void viewAccount(int accID) throws SQLException {
	    String sql = "SELECT * FROM ACCOUNT WHERE account_id = ?";
	    try (Connection con = DBconnection.getConnection(); 
	        PreparedStatement st = con.prepareStatement(sql)) {
	        st.setInt(1, accID);
	        ResultSet rs = st.executeQuery(); 
	        if (rs.next()) {
	            System.out.println("Account ID    : " + rs.getInt("account_id"));
	            System.out.println("Customer ID   : " + rs.getInt("customer_id"));
	            System.out.println("Bank ID       : " + rs.getInt("bank_id"));
	            System.out.println("Account Type  : " + rs.getString("account_type"));
	            System.out.println("Balance       : " + rs.getDouble("balance"));
	        } else {
	            System.out.println("No account found with ID: " + accID);
	        }
	    }
	}

	
	


}
