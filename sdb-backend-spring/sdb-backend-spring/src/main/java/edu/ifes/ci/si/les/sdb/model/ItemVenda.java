package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


//import net.minidev.json.annotate.JsonIgnore;

@Entity
public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@JsonIgnore
	@EmbeddedId
	private ItemDeVendaPK id = new ItemDeVendaPK();
	
	private Integer quantidadeVenda;

	public ItemVenda() {
		// TODO Auto-generated constructor stub
	}

	public ItemVenda(Venda venda, Produto produto, Integer quantidadeVenda) {
		this.id.setVenda(venda);
		this.id.setProduto(produto);
		this.quantidadeVenda=quantidadeVenda;
	}
	
	public ItemDeVendaPK getId() {
		return id;
	}
	public Integer getQuantidadeVenda() {
		return quantidadeVenda;
	}
	public void setId(ItemDeVendaPK id) {
		this.id = id;
	}
	public void setQuantidadeVenda(Integer quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}
	
	public Venda getVenda() {
		return id.getVenda();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	@Override
	public String toString() {
		return this.getQuantidadeVenda().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			 return false;
			 if (getClass() != obj.getClass())
			 return false;
			 final ItemVenda other = (ItemVenda) obj;
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
