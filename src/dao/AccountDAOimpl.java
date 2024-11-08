package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.InvalidAccountTypeException;
import model.Account;
import utility.DBconnection;

public class AccountDAOimpl implements AccountDAO {

	@Override
	public void createAccount(Account account) throws SQLException, InvalidAccountTypeException {
		
		String sql="INSERT INTO ACCOUNT (customer_id, bank_id, account_type, balance) VALUES (?,?,?,?)";
		
		try(Connection con= DBconnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
				
				ps.setInt(1, account.getCustomer_id());
				ps.setInt(2, account.getBank().getBank_id());
				ps.setString(3, account.getAccount_type());
				ps.setDouble(4,account.getBalance());
				
				int result =ps.executeUpdate();
				if(result == 0)
				{
					throw new InvalidAccountTypeException ("Account Type not recognized");
				}
		}
				
				
				
	}

}
