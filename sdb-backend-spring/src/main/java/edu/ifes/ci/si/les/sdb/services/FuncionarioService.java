package edu.ifes.ci.si.les.sdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.repositories.FuncionarioRepository;
import edu.ifes.ci.si.les.sdb.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sdb.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario find(Integer id) {
		Funcionario obj = funcionarioRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Funcionario.class.getName());
		}
		return obj;
	}
	
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return funcionarioRepository.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
		find(obj.getId());
		return funcionarioRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			funcionarioRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Funcionario (Funcionario) associada a Reservas ou Empréstimos");
		}
	}
	
	public Funcionario findByLoginAndSenha(String login, String senha){
		return funcionarioRepository.findByLoginAndSenha(login, senha);
	}
	
}
