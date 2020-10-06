package edu.ifes.ci.si.les.sdb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sdb.model.Cidade;
import edu.ifes.ci.si.les.sdb.repositories.CidadeRepository;


    @Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

		public Cidade find(Integer id) {
		Cidade obj = cidadeRepository.findOne(id);
		return obj;
		}
		
		public List<Cidade> findAll() {
		return cidadeRepository.findAll();
		}
		
		public Cidade insert(Cidade obj) {
		return cidadeRepository.save(obj);
		}
		
		public Cidade update(Cidade obj) {
		find(obj.getId());
		return cidadeRepository.save(obj);
		}
		
		public void delete(Integer id) {
		cidadeRepository.delete(id);
		}

}
