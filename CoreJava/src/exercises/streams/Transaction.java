package exercises.streams;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* 
 * Exercise 4:
 * 
 * Create an application which connects to a database and
 * transfers money from one account to another.
 * The transfer has to be a 'Transaction', meaning that is should not be possible to 
 * increase the balance of one account without subtracting the same value from another
 * */

public class Transaction {

	private int fromId;
	private int toId;
	private double amount;

	public Transaction(int fromId, int toId, double amount) {
		this.fromId = fromId;
		this.toId = toId;
		this.amount = amount;
	}

	public void transfer() {
		// password for local DB is omitted here 
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC", "root",
				"");) {
				
				// This statement calls a procedure on the DB "transfer(double amount, int from_id, int to_id)"
				// It achieves the same effect as the three commented statements bellow.
				CallableStatement transfer = conn.prepareCall("{CALL transfer(?,?,?)}");
				transfer.setDouble(1, amount);
				transfer.setInt(2, fromId);
				transfer.setInt(3, toId);
				transfer.execute();
				System.out.println("Moved " + amount + " from account id: " + fromId + ", to account id: " + toId);

//			PreparedStatement values = conn.prepareStatement("SELECT ballance FROM accounts WHERE account_id=?");
//			PreparedStatement subtr = conn.prepareStatement("UPDATE accounts SET ballance = ? - ? WHERE account_id = ?");
//			PreparedStatement add = conn.prepareStatement("UPDATE accounts SET ballance = ? + ? WHERE account_id = ?");
//
//			conn.setAutoCommit(false);
//
//			values.setInt(1, fromId);
//			ResultSet rs = values.executeQuery();
//			rs.next();
//			double fromBalance = rs.getDouble(1);
//
//			values.setInt(1, toId);
//			rs = values.executeQuery();
//			rs.next();
//			double toBalance = rs.getDouble(1);
//
//			subtr.setDouble(1, fromBalance);
//			subtr.setDouble(2, amount);
//			subtr.setInt(3, fromId);
//			subtr.executeUpdate();
//			System.out.println("Subtracted: " + amount + " from account_id: " + fromId);
//
//			add.setDouble(1, toBalance);
//			add.setDouble(2, amount);
//			add.setInt(3, toId);
//			add.executeUpdate();
//			conn.commit();
//			System.out.println("Moved: " + amount + " from id: " + fromId + " to id: " + toId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
