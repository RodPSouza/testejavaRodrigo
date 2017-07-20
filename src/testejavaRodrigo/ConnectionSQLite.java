package testejavaRodrigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionSQLite {

	private Connection c = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private String url = "jdbc:sqlite:Cliente.db";
	private String driver = "org.sqlite.JDBC";

	public void openConnectionSQLite(String sql) throws ClassNotFoundException, SQLException {

		try {

			Class.forName(driver);
			c = DriverManager.getConnection(url);

			stmt = c.prepareStatement(sql);

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public void openConnection(String sql) throws ClassNotFoundException, SQLException {

		this.openConnectionSQLite(sql);

	}

	public void closeConnection() throws ClassNotFoundException, SQLException {

		this.stmt.close();
		this.c.close();

	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}