package testejavaRodrigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableSQLite {

	public static void main(String[] args) {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Cliente.db");

			stmt = c.createStatement();
			String sql = "Create table tb_customer_account " + "(ID_CUSTOMER INT PRIMARY KEY NOT NULL,"
					+ " CPF_CNPJ           INT    NOT NULL, " + " NM_CUSTOMER           TEXT    NOT NULL, "
					+ " IS_ACTIVE            INT     NOT NULL, " + " VL_TOTAL         REAL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Sucess!");
	}

}
