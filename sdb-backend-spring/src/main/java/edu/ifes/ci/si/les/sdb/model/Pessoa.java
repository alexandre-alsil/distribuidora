package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashSet;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String cpfCnpj;

	private Integer tipo;

	private String rua;

	private String numero;

	private String email;

	private Integer status;

	@ManyToOne
	@JoinColumn(name="bairro_id")
	private Bairro bairro;

	//@OneToMany(mappedBy="id", cascade=CascadeType.ALL) //duvida sobre o atributo
	//private List<Telefone> telefones = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();

	public Pessoa() {
		
	}
	
	public Pessoa(Integer id, String nome, String cpfCnpj, Integer tipo, String rua, String numero, String email, Integer status, Bairro bairro) {
		this.id=id;
		this.nome=nome;
		this.cpfCnpj=cpfCnpj;
		this.tipo=tipo;
		this.rua=rua;
		this.numero=numero;
		this.email=email;
		this.status=status;
		this.bairro=bairro;
		
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public Integer getTipo() {
		return tipo;
	}
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public String getEmail() {
		return email;
	}
	public Integer getStatus() {
		return status;
	}
	public Bairro getBairro() {
		return bairro;
	}
	
	
	
	public Set<String> getTelefone() {
		return telefones;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public void setTelefone(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			 return false;
			 if (getClass() != obj.getClass())
			 return false;
			 final Pessoa other = (Pessoa) obj;
			 if (!Objects.equals(this.id, other.id))
			 return false;
			 return true;
	}
	
	@Override
	public int hashCode() {
		 int hash = 7;
		 hash = 97 * hash + Objects.hashCode(this.id);
		 return hash;
	}
	
}
