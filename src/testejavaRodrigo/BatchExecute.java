package testejavaRodrigo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class BatchExecute {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Customer_Account_Dao dao = new Customer_Account_Dao();
		Random records = new Random();
		int ctrl = 2701;
		String fechaConexao = "N";

		Calendar c = Calendar.getInstance();

		System.out.println(
				"Inicio: " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "\n");

		System.out.println("Inserindo registros...\n");
		System.out.println("Obs.:O sistema irá demorar de 7 a 10 minutos para inserir os registros...\n");

		for (int i = 0; i < ctrl; i++) {

			if (i == ctrl - 1) {

				fechaConexao = "S";
			}

			String recordsString = RandomStringUtils.randomAlphabetic(10);

			Customer_Account account = new Customer_Account(0, records.nextInt(999999999), recordsString,
					Boolean.compare(records.nextBoolean(), false), records.nextInt(999) + 280);

			dao.Insert_Customer_Account(account.getCpf_Cnpj(), account.getNm_Customer(), account.getIs_Active(),
					account.getVl_total(), fechaConexao);

		}

		System.out.println("Exibindo a média: \n");

		System.out.println(dao.buscarValorUnico(
				"SELECT round(avg(vl_total),2) media FROM tb_customer_account WHERE vl_total > 560.00 and id_customer between 1500 and 2700",
				"media") + "\n");

		System.out.println("Exibindo as contas dos clientes envolvidos no cálculo da média: \n");

		System.out.println(dao.listar(
				"select * FROM tb_customer_account WHERE vl_total > 560.00 and id_customer between 1500 and 2700"));

		Calendar cd = Calendar.getInstance();

		System.out.println(
				"Fim: " + cd.get(Calendar.HOUR) + ":" + cd.get(Calendar.MINUTE) + ":" + cd.get(Calendar.SECOND));

	}
}
