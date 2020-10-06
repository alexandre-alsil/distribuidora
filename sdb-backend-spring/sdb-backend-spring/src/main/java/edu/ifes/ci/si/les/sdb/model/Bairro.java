package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bairro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	public Bairro() {
	}
	
	public Bairro(Integer id, String nome, Cidade cidade) {
		this.id=id;
		this.nome=nome;
		this.cidade=cidade;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
			 final Bairro other = (Bairro) obj;
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
