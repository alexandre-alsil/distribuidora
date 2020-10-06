package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UF implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;

	private String nome;

	private String sigla;

	public UF() {
		
	}
	
	public UF(Integer id, String sigla, String nome) {
		this.id=id;
		this.sigla=sigla;
		this.nome=nome;
		
	}
	
public Integer getId() {
	return id;
}

public String getNome() {
	return nome;
}

public String getSigla() {
	return sigla;
}

public void setId(Integer id) {
	this.id = id;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setSigla(String sigla) {
	this.sigla = sigla;
}

@Override
public String toString() {
	return nome;
}

@Override
public boolean equals(Object obj) {
	 if (obj == null) {
         return false;
     }
     if (getClass() != obj.getClass()) {
         return false;
     }
		 final UF other = (UF) obj;
		 
		 if (!Objects.equals(this.id, other.id)) {
		 return false;
		 }
		 return true;
}

@Override
public int hashCode() {
	 int hash = 7;
	 hash = 97 * hash + Objects.hashCode(this.id);
	 return hash;

}

}
