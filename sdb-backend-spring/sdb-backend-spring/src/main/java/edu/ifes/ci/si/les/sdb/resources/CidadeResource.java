package edu.ifes.ci.si.les.sdb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sdb.model.Cidade;
import edu.ifes.ci.si.les.sdb.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")

public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findAll() {
	List<Cidade> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cidade> find(@PathVariable Integer id) {
	Cidade obj = service.find(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cidade obj) {
	obj = service.insert(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cidade obj) {
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
	service.delete(id);
	return ResponseEntity.noContent().build();
	}
	
}
