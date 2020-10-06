package edu.ifes.ci.si.les.sdb.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeName;

/**
 *
 * @author Alexandre
 */

@JsonTypeName("Cliente")
@JsonIgnoreProperties({ "@type" })
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Integer id, String nome, String cpfCnpj, Integer tipo, String rua, String numero, String email, Integer status, Bairro bairro, Funcionario funcionario) {
		super(id, nome, cpfCnpj, tipo, rua, numero, email, status, bairro);
		this.funcionario=funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	

}
