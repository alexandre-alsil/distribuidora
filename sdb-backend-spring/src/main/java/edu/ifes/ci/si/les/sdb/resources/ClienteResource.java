package edu.ifes.ci.si.les.sdb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import edu.ifes.ci.si.les.sdb.model.Emprestimo;
import edu.ifes.ci.si.les.sdb.services.ClienteService;
//import edu.ifes.ci.si.les.sdb.services.EmprestimoService;
import edu.ifes.ci.si.les.sdb.model.Cliente;


@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	//@Autowired
	//private EmprestimoService emprestimoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
		obj = service.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente obj) {
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
