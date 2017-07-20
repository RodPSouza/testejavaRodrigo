package testejavaRodrigo;

public class Customer_Account {

	private Integer id_Customer;
	private Integer cpf_Cnpj;
	private String nm_Customer;
	private Integer is_Active;
	private long vl_total;

	public Customer_Account(Integer id_Customer, Integer cpf, String nm_Customer, Integer is_Active, long vl_total) {

		this.id_Customer = id_Customer;
		this.cpf_Cnpj = cpf;
		this.nm_Customer = nm_Customer;
		this.is_Active = is_Active;
		this.vl_total = vl_total;

	}

	public Integer getId_Customer() {
		return id_Customer;
	}

	public Integer getCpf_Cnpj() {
		return cpf_Cnpj;
	}

	public String getNm_Customer() {
		return nm_Customer;
	}

	public Integer getIs_Active() {
		return is_Active;
	}

	public long getVl_total() {
		return vl_total;
	}

	@Override
	public String toString() {

		return String.format("Id:  %d   Cpf:  %d  Nome:  %s   Recebido:  %s  ValorTotal:  %d  \n", id_Customer,
				cpf_Cnpj, nm_Customer, ((is_Active == 1) ? "Sim" : "Não"), vl_total);
	}

}
