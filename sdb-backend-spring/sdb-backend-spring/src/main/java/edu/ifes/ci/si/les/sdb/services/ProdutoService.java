package edu.ifes.ci.si.les.sdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import edu.ifes.ci.si.les.sdb.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sdb.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.sdb.model.Produto;
import edu.ifes.ci.si.les.sdb.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto find(Integer id) {
		Produto obj = produtoRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Produto.class.getName());
		}
		return obj;
	}
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return produtoRepository.save(obj);
	}
	
	public Produto update(Produto obj) {
		find(obj.getId());
		return produtoRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			produtoRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Produto vinculado a itens de venda ou itens de compra");
		}
	}
	
}
