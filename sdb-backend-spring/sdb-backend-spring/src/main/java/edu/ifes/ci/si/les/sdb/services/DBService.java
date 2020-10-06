package edu.ifes.ci.si.les.sdb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.sdb.repositories.BairroRepository;
import edu.ifes.ci.si.les.sdb.repositories.CidadeRepository;
import edu.ifes.ci.si.les.sdb.repositories.ClienteRepository;
import edu.ifes.ci.si.les.sdb.repositories.CompraRepository;
import edu.ifes.ci.si.les.sdb.repositories.FornecedorRepository;
import edu.ifes.ci.si.les.sdb.repositories.FuncionarioRepository;
import edu.ifes.ci.si.les.sdb.repositories.ItemCompraRepository;
import edu.ifes.ci.si.les.sdb.repositories.ItemVendaRepository;
import edu.ifes.ci.si.les.sdb.repositories.ProdutoRepository;
import edu.ifes.ci.si.les.sdb.model.Cliente;
import edu.ifes.ci.si.les.sdb.model.Compra;
import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.model.Cidade;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.model.ItemCompra;
import edu.ifes.ci.si.les.sdb.model.ItemVenda;
import edu.ifes.ci.si.les.sdb.model.Produto;
import edu.ifes.ci.si.les.sdb.model.UF;
import edu.ifes.ci.si.les.sdb.model.Venda;
import edu.ifes.ci.si.les.sdb.repositories.UFRepository;
import edu.ifes.ci.si.les.sdb.repositories.VendaRepository;

@Service
public class DBService {

	@Autowired
	private UFRepository ufRepository;
	@Autowired
	private BairroRepository bairroRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		//Inserindo UFs no banco de dados
		UF uf1 = new UF(1,"ES", "Espírito Santo");
		UF uf2 = new UF(2, "MG", "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Cachoeiro",uf1);
		Cidade c2 = new Cidade(null, "Alegre",uf1);
		Cidade c3 = new Cidade(null, "Belo Horizonte",uf2);
		Cidade c4 = new Cidade(null, "Caratinga",uf2);
						
		//Inserindo Bairros no BD
		Bairro b1 = new Bairro(null,"Marbrasa",c1);
		Bairro b2 = new Bairro(null,"BNH",c1);
		Bairro b3 = new Bairro(null,"Centro Alegre",c2);
		Bairro b4 = new Bairro(null,"Roça Alegre",c2);
		Bairro b5 = new Bairro(null,"Pampulha",c3);
		Bairro b6 = new Bairro(null,"Dona Clara",c3);
		Bairro b7 = new Bairro(null,"Centro Carat",c4);
		Bairro b8 = new Bairro(null,"Roça Carat",c4);			
		
		
		Funcionario f1 = new Funcionario(null, "Alexandre", "111111111-11", 1, "Rua 45", "1001", "abc@sdb.com.br", 1, b1, "root", "1234");
		Funcionario f2 = new Funcionario(null, "Magneto", "222222222-22", 1, "Rua A", "2002", "mgn@sdb.com.br", 1, b2, "root", "1234");
		Funcionario f3 = new Funcionario(null, "Jonh", "333333333-33", 1, "Rua Leste", "3003", "jhn@sdb.com.br", 1, b3, "root", "1234");
		
		Cliente cliente1 = new Cliente(null, "Alex", "444444444-44", 1, "Rua B", "101", "alx@cliente.com.br", 1, b4, f1);
		Cliente cliente2 = new Cliente(null, "Thiago", "555.555.555-55", 1, "Rua C", "202", "thg@cliente.com.br", 2, b5, f2);
		Cliente cliente3 = new Cliente(null, "Marlon", "666.666.666-66", 1, "Rua D", "303", "mrl@cliente.com.br", 2, b6, f3);
		Cliente cliente4 = new Cliente(null, "Luisa", "777.777.777-77", 1, "Rua E", "404", "lsa@cliente.com.br", 1, b7, f1);
		
		//Alterando a forma de inserir os telefones
		cliente1.getTelefones().addAll(Arrays.asList("111111111", "222222222"));
		cliente2.getTelefones().addAll(Arrays.asList("333333333", "444444444"));
		cliente3.getTelefones().addAll(Arrays.asList("555555555", "666666666"));
		cliente4.getTelefones().addAll(Arrays.asList("777777777", "888888888"));
		f1.getTelefones().addAll(Arrays.asList("123456789", "234567890"));
		f2.getTelefones().addAll(Arrays.asList("345678901", "456789032"));
		f3.getTelefones().addAll(Arrays.asList("567890321", "678903214"));
		
		 		
		Fornecedor fd1 = new Fornecedor(null, "Renan", "888.888.888-88", 1, "Rua F", "505", "rnn@fornecedor.com.br", 1, b2, f1);
		Fornecedor fd2 = new Fornecedor(null, "Luis", "999.999.999-99-88", 1, "Rua G", "606", "lui@fornecedor.com.br", 1, b5, f2);
		
		Produto p1 = new Produto(null, "Cerveja A", 1, 10.55, 15.66, 18.22, 20, 10, 1, "A", "Z", f1);
		Produto p2 = new Produto(null, "Cerveja B", 1, 20.55, 25.66, 28.22, 30, 10, 1, "B", "Y", f2);
		Produto p3 = new Produto(null, "Cerveja C", 1, 30.55, 35.66, 38.22, 40, 10, 1, "C", "X", f1);
		Produto p4 = new Produto(null, "Cerveja D", 1, 40.55, 45.66, 48.22, 50, 10, 1, "A", "Z", f2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Compra co1 = new Compra(null, sdf.parse("01/04/2019 08:45"), sdf.parse("01/04/2019 08:45"), 1, 102.20, 1, f1, fd1);
		Compra co2 = new Compra(null, sdf.parse("10/04/2019 08:45"), sdf.parse("25/04/2019 08:45"), 2, 204.40, 1, f2, fd2);
	
		
		ItemCompra ic1 = new ItemCompra(co1,p1,1);
		ItemCompra ic2 = new ItemCompra(co1,p2,1);
		ItemCompra ic3 = new ItemCompra(co1,p3,1);
		ItemCompra ic4 = new ItemCompra(co1,p4,1);
		
		ItemCompra ic5 = new ItemCompra(co2,p1,2);
		ItemCompra ic6 = new ItemCompra(co2,p2,2);
		ItemCompra ic7 = new ItemCompra(co2,p3,2);
		ItemCompra ic8 = new ItemCompra(co2,p4,2);
				
		
		Venda v1 = new Venda(null, sdf.parse("12/04/2019 15:00"), "Rua J", "111", 54.66, 1, cliente1, f1, b1);
		Venda v2 = new Venda(null, sdf.parse("15/04/2019 15:00"), "Rua K", "222", 84.66, 1, cliente2, f2, b3);
		
		ItemVenda iv1 = new ItemVenda(v1,p1,3);
		ItemVenda iv2 = new ItemVenda(v2,p2,3);
		
		
		ufRepository.save(Arrays.asList(uf1, uf2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3, c4));
		bairroRepository.save(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8));
		funcionarioRepository.save(Arrays.asList(f1,f2,f3));
		clienteRepository.save(Arrays.asList(cliente1,cliente2,cliente3,cliente4));
		fornecedorRepository.save(Arrays.asList(fd1,fd2));
		produtoRepository.save(Arrays.asList(p1,p2,p3,p4));
		compraRepository.save(Arrays.asList(co1,co2));
		itemCompraRepository.save(Arrays.asList(ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8));
		vendaRepository.save(Arrays.asList(v1,v2));
		itemVendaRepository.save(Arrays.asList(iv1,iv2));
	}
	
}
