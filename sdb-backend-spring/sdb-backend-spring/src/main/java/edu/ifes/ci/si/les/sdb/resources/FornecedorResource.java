package edu.ifes.ci.si.les.sdb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Fornecedor> find(@PathVariable Integer id) {
		Fornecedor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Fornecedor obj) {
		obj = service.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fornecedor obj) {
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*@RequestMapping(value="/{clienteId}/emprestimos", method=RequestMethod.GET)
	public ResponseEntity<List<Emprestimo>> findEmprestimos(@PathVariable Integer clienteId) {
		List<Emprestimo> list = emprestimoService.findEmprestimos(clienteId);  
		return ResponseEntity.ok().body(list);
	}*/
}
