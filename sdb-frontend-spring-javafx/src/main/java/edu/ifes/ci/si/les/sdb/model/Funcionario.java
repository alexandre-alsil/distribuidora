package edu.ifes.ci.si.les.sdb.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeName;


@JsonTypeName("Funcionario")
@JsonIgnoreProperties({ "@type" })
public class Funcionario extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	
	private String login;

	private String senha;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario(Integer id, String nome, String cpfCnpj, Integer tipo, String rua, String numero, String email, Integer status, Bairro bairro, String login, String senha) {
		super(id, nome, cpfCnpj, tipo, rua, numero, email, status, bairro);
		this.login=login;
		this.senha=senha;
	}
	
		
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	
}
