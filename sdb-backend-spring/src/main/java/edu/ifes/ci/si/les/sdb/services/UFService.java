package edu.ifes.ci.si.les.sdb.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sdb.model.UF;
import edu.ifes.ci.si.les.sdb.repositories.UFRepository;

	@Service
public class UFService {

		@Autowired
		private UFRepository ufRepository;
	
	public UF find(Integer id) {
	UF obj = ufRepository.findOne(id);
	return obj;
	}
	
	public List<UF> findAll() {
	return ufRepository.findAll();
	}
	
	public UF insert(UF obj) {
	return ufRepository.save(obj);
	}
	
	public UF update(UF obj) {
	find(obj.getId());
	return ufRepository.save(obj);
	}
	
	public void delete(Integer id) {
	ufRepository.delete(id);
	}

	}
