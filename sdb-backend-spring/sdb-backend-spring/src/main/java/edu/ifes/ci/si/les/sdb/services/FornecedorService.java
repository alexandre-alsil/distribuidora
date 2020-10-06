package edu.ifes.ci.si.les.sdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.repositories.FornecedorRepository;
import edu.ifes.ci.si.les.sdb.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sdb.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor find(Integer id) {
		Fornecedor obj = fornecedorRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Fornecedor.class.getName());
		}
		return obj;
	}
	
	public List<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor insert(Fornecedor obj) {
		obj.setId(null);
		return fornecedorRepository.save(obj);
	}
	
	public Fornecedor update(Fornecedor obj) {
		find(obj.getId());
		return fornecedorRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			fornecedorRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Fornecedor (Fornecedor) associada a Produtos");
		}
	}
	
}
