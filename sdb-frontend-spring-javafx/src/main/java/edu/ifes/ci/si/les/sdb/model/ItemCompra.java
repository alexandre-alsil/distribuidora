package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer quantidadeCompra;

    private Double subTotal;

    private Compra compra;

    private Produto produto;
    
    private List<Produto> produtos = new ArrayList<>();

    public ItemCompra(Compra compra, Produto produto, Integer quantidadeCompra) {
        this.compra = compra;
        this.produto = produto;
        this.quantidadeCompra = quantidadeCompra;
    }

    public ItemCompra() {
        // TODO Auto-generated constructor stub
    }

    public Integer getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public Double getSubTotal() {
        subTotal = quantidadeCompra * produto.getPrecoCompra();
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        
        this.subTotal = subTotal;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidadeCompra(Integer quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
