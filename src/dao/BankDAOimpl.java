package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exception.BankingException;
import model.Bank;
import utility.DBconnection;

public class BankDAOimpl implements BankDAO {

	@Override
	public Bank getBankById(int id) throws SQLException, BankingException {
		
        	String query= "SELECT * FROM BANK WHERE bank_id=?";
        	try(Connection con= DBconnection.getConnection(); PreparedStatement stmt=con.prepareStatement(query)){
        		stmt.setInt(1,id);
        		ResultSet rs=stmt.executeQuery();
        		if(rs.next()) {
        			return new Bank(id, rs.getString("bank_name"),rs.getString("bank_branch"));
        		}
        		throw new BankingException("No Bank is present for this id :"+id);
        	}
 }
	
}
