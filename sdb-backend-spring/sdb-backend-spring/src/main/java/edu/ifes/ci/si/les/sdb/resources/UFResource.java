package edu.ifes.ci.si.les.sdb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sdb.model.UF;
import edu.ifes.ci.si.les.sdb.services.UFService;

@RestController
@RequestMapping(value = "/ufs")


public class UFResource {
	
	@Autowired
	private UFService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UF>> findAll() {
	List<UF> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UF> find(@PathVariable Integer id) {
	UF obj = service.find(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UF obj) {
	obj = service.insert(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UF obj) {
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
	service.delete(id);
	return ResponseEntity.noContent().build();
	}
}
