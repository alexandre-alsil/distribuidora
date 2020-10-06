package edu.ifes.ci.si.les.sdb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;

public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Date data;

    private Date dataVencimento;

    private Integer formaPagamento;

    private Double total;
    
    private String totalS;

    private Integer status;

    private Funcionario funcionario;

    private Fornecedor fornecedor;

    //@OneToMany(mappedBy="id") //duvida sobre o atributo
    //private List<Produto> itemCompra;
    private List<ItemCompra> itens = new ArrayList<>();

    public Compra() {
        // TODO Auto-generated constructor stub
    }

    public Compra(Integer id, Date data, Date dataVencimento, Integer formaPagamento, Double total,
            Integer status, Funcionario funcionario, Fornecedor fornecedor) {
        this.id = id;
        this.data = data;
        this.dataVencimento = dataVencimento;
        this.formaPagamento = formaPagamento;
        this.total = total;
        this.status = status;
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        
        //this.totalS = String.valueOf(total);

    }

    public Integer getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public Integer getStatus() {
        return status;
    }

    public Double getTotal() {
        return total;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    //public List<Produto> getItemCompra() {
    //	return itemCompra;
    //}

    public List<ItemCompra> getItemCompra() {
        return itens;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    //public void setItemCompra(List<Produto> itemCompra) {
    //	this.itemCompra = itemCompra;
    //}

    public void setItemCompra(List<ItemCompra> itemCompra) {
        this.itens = itemCompra;
    }

    @Override
    public String toString() {
        return this.getFuncionario().getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
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
