package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//import net.minidev.json.annotate.JsonIgnore;

@Entity
public class ItemCompra implements Serializable{

private static final long serialVersionUID = 1L;
	
	//@JsonIgnore
	@EmbeddedId
	private ItemDeCompraPK id = new ItemDeCompraPK();
	
	private Integer quantidadeCompra;


	public ItemCompra(Compra compra, Produto produto, Integer quantidadeCompra) {
		this.id.setCompra(compra);
		this.id.setProduto(produto);
		this.quantidadeCompra=quantidadeCompra;
	}
	
	public ItemCompra() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemDeCompraPK getId() {
		return id;
	}
	public Integer getQuantidadeCompra() {
		return quantidadeCompra;
	}
	
	public Compra getCompra() {
		return id.getCompra();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setCompra(Compra compra) {
		id.setCompra(compra);
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public void setId(ItemDeCompraPK id) {
		this.id = id;
	}
	public void setQuantidadeCompra(Integer quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

	@Override
	public String toString() {
		return "ItemDeCompra{" + "id=" + id + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			 return false;
			 if (getClass() != obj.getClass())
			 return false;
			 final ItemCompra other = (ItemCompra) obj;
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
