package edu.ifes.ci.si.les.sdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.sdb.model.Cliente;
import edu.ifes.ci.si.les.sdb.repositories.ClienteRepository;
import edu.ifes.ci.si.les.sdb.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sdb.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		Cliente obj = clienteRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		find(obj.getId());
		return clienteRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Cliente (Cliente) associada a Reservas ou Empréstimos");
		}
	}
}