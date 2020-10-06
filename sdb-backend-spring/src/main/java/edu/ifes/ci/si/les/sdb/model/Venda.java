package edu.ifes.ci.si.les.sdb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Date data;

	private String rua;

	private String numero;

	private Double total;

	private Integer status;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;

	//@OneToMany(mappedBy="id") //duvida sobre o atributo
	//private List<Produto> itemVenda;
	@OneToMany(mappedBy="id.venda")
    private List<ItemVenda> itens = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="bairro_id")
	private Bairro bairro;

	public Venda() {
		// TODO Auto-generated constructor stub
	}
	
	public Venda(Integer id, Date data, String rua, String numero,Double total,Integer status,Cliente cliente,
			Funcionario funcionario, Bairro bairro) {
		this.id=id;
		this.data=data;
		this.rua=rua;
		this.numero=numero;
		this.total=total;
		this.status=status;
		this.cliente=cliente;
		this.funcionario=funcionario;
		this.bairro=bairro;
	}
	
	public Integer getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public Date getData() {
		return data;
	}
	public String getNumero() {
		return numero;
	}
	public String getRua() {
		return rua;
	}
	public Integer getStatus() {
		return status;
	}
	public Double getTotal() {
		return total;
	}
	//public List<Produto> getItemVenda() {
	//	return itemVenda;
	//}
	public List<ItemVenda> getItemVenda() {
		return itens;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	//public void setItemVenda(List<Produto> itemVenda) {
	//	this.itemVenda = itemVenda;
	//}
	public void setItemVenda(List<ItemVenda> itemVenda) {
		this.itens = itemVenda;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	public String toString() {
		return this.getFuncionario().getNome();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			 return false;
			 if (getClass() != obj.getClass())
			 return false;
			 final Venda other = (Venda) obj;
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
