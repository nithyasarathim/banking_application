package dao;

import java.sql.SQLException;
import exception.BankingException;

import model.Bank;

public interface BankDAO {
   public Bank getBankById(int id) throws SQLException, BankingException;
}
