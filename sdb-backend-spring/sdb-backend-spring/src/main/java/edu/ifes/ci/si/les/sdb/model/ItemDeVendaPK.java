package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class ItemDeVendaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="venda_id")
	private Venda venda;
	
	public Produto getProduto() {
		return produto;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.venda);
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
        final ItemDeVendaPK other = (ItemDeVendaPK) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
	
}
