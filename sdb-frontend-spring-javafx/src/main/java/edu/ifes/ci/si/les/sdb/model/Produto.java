package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String nome;

	private Integer tipo;

	private Double precoCompra;

	private Double precoPromocao;

	private Double precoVenda;

	private Integer estoque;

	private Integer estoqueMinimo;

	private Integer status;

	private String curvaABC;

	private String curvaXYZ;

	private Funcionario funcionario;

	private List<Fornecedor> fornecedor = new ArrayList<>();
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(Integer id, String nome, Integer tipo, Double precoCompra, Double precoPromocao, Double precoVenda, 
			Integer estoque, Integer estoqueMinimo, Integer status, String curvaABC, String curvaXYZ, 
			Funcionario funcionario) {
		    this.id=id;
		    this.nome=nome;
		    this.tipo=tipo;
		    this.precoCompra=precoCompra;
		    this.precoPromocao=precoPromocao;
		    this.precoVenda=precoVenda;
		    this.estoque=estoque;
		    this.estoqueMinimo=estoqueMinimo;
		    this.status=status;
		    this.curvaABC=curvaABC;
		    this.curvaXYZ=curvaXYZ;
		    this.funcionario=funcionario;
		    
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public Double getPrecoCompra() {
		return precoCompra;
	}
	public Double getPrecoPromocao() {
		return precoPromocao;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public Integer getStatus() {
		return status;
	}
	public String getCurvaABC() {
		return curvaABC;
	}
	public String getCurvaXYZ() {
		return curvaXYZ;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setCurvaABC(String curvaABC) {
		this.curvaABC = curvaABC;
	}
	public void setCurvaXYZ(String curvaXYZ) {
		this.curvaXYZ = curvaXYZ;
	}
	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
			 final Produto other = (Produto) obj;
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
