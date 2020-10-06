package edu.ifes.ci.si.les.sdb.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Cliente")
@JsonIgnoreProperties({ "@type" })
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name="funcionario_id")
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
