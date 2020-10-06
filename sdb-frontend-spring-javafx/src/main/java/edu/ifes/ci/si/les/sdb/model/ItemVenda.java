package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

public class ItemVenda implements Serializable {

    private static final long serialVersionUID = 1L;

    private Produto produto;

    private Venda venda;

    private Double subTotal;

    private Integer quantidadeVenda;

    public ItemVenda() {
        // TODO Auto-generated constructor stub
    }

    public ItemVenda(Venda venda, Produto produto, Integer quantidadeVenda) {
        this.produto = produto;
        this.venda = venda;
        this.quantidadeVenda = quantidadeVenda;
    }

    public Integer getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(Integer quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return this.getQuantidadeVenda().toString();
    }

}
