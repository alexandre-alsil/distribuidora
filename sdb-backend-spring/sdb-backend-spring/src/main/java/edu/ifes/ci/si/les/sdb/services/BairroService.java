package edu.ifes.ci.si.les.sdb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.repositories.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository bairroRepository;

		public Bairro find(Integer id) {
		Bairro obj = bairroRepository.findOne(id);
		return obj;
		}
		
		public List<Bairro> findAll() {
		return bairroRepository.findAll();
		}
		
		public Bairro insert(Bairro obj) {
		return bairroRepository.save(obj);
		}
		
		public Bairro update(Bairro obj) {
		find(obj.getId());
		return bairroRepository.save(obj);
		}
		
		public void delete(Integer id) {
			bairroRepository.delete(id);
		}
	
	
}
