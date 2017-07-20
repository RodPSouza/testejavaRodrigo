package testejavaRodrigo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer_Account_Dao {

	private ConnectionSQLite objCon = new ConnectionSQLite();

	public void Insert_Customer_Account(Integer cpf, String nm_Customer, Integer is_Active, long vl_total,
			String fechaConexao) throws ClassNotFoundException, SQLException {

		if (fechaConexao == "N") {
			
			//Obs.: Apenas lembrando que SQLite não possui funcionalidade autoincremental proprietária 
			String sql = "Insert Into tb_customer_account (id_Customer, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL) "
					+ "	  values ((Select Count(id_Customer) + 1 From tb_customer_account),?,?,?,?)";

			objCon.openConnection(sql);
			objCon.getStmt().setInt(1, cpf);
			objCon.getStmt().setString(2, nm_Customer);
			objCon.getStmt().setInt(3, is_Active);
			objCon.getStmt().setDouble(4, vl_total);
			objCon.getStmt().execute();

		} else {

			objCon.closeConnection();
		}

	}

	public List<Customer_Account> listar(String sql) throws SQLException, ClassNotFoundException {

		List<Customer_Account> c_account = new ArrayList<>();

		objCon.openConnection(sql);
		objCon.getStmt().execute();
		objCon.setRs(objCon.getStmt().getResultSet());

		while (objCon.getRs().next()) {

			int id = objCon.getRs().getInt("id_Customer");
			int cpf = objCon.getRs().getInt("cpf_Cnpj");
			String name = objCon.getRs().getString("nm_Customer");
			int active = objCon.getRs().getInt("is_Active");
			long value = objCon.getRs().getLong("vl_Total");

			Customer_Account customer = new Customer_Account(id, cpf, name, active, value);
			c_account.add(customer);
		}

		objCon.closeConnection();

		return c_account;

	}

	public Double buscarValorUnico(String sql, String alias) throws SQLException, ClassNotFoundException {

		Double valorUnico = 0.0;

		objCon.openConnection(sql);
		objCon.getStmt().execute();
		objCon.setRs(objCon.getStmt().getResultSet());

		while (objCon.getRs().next()) {

			valorUnico = objCon.getRs().getDouble(alias);

		}

		objCon.closeConnection();

		return valorUnico;

	}

}
