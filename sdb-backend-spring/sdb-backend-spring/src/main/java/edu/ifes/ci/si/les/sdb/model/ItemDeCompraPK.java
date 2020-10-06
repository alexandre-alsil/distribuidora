package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ItemDeCompraPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="compra_id")
	private Compra compra;
	
	public Compra getCompra() {
		return compra;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.compra);
        hash = 13 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemDeCompraPK other = (ItemDeCompraPK) obj;
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
	
}
