package edu.ifes.ci.si.les.sdb;

//import java.util.Arrays;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import edu.ifes.ci.si.les.sdb.model.UF;
//import edu.ifes.ci.si.les.sdb.model.Cidade;
//import edu.ifes.ci.si.les.sdb.model.Bairro;
//import edu.ifes.ci.si.les.sdb.repositories.BairroRepository;
//import edu.ifes.ci.si.les.sdb.repositories.CidadeRepository;
//import edu.ifes.ci.si.les.sdb.repositories.UFRepository;

@SpringBootApplication
public class SdbBackendSpringApplication implements CommandLineRunner {

	//@Autowired
	//private UFRepository ufRepository;
	//private CidadeRepository cidadeRepository;
	//private BairroRepository bairroRepository;
	public static void main(String[] args) {
		SpringApplication.run(SdbBackendSpringApplication.class, args);
		System.out.println("estou aqui1");
	}
	
	@Override
	public void run(String... args) throws Exception {
	//Inserindo UFs no banco de dados
	/*UF uf1 = new UF(1,"ES", "Espírito Santo");
	UF uf2 = new UF(2, "MG", "Minas Gerais");
	ufRepository.save(Arrays.asList(uf1, uf2));
	*/
	//Inserindo Cidades no BD
	/*Cidade c1 = new Cidade(1, "Cachoeiro",uf1);
	Cidade c2 = new Cidade(2, "Alegre",uf1);
	Cidade c3 = new Cidade(3, "Belo Horizonte",uf2);
	Cidade c4 = new Cidade(4, "Caratinga",uf2);
	cidadeRepository.save(Arrays.asList(c1, c2, c3, c4));*/
	
	
	//Inserindo Bairros no BD
	/*Bairro b1 = new Bairro(1,"Marbrasa",c1);
	Bairro b2 = new Bairro(2,"BNH",c1);
	Bairro b3 = new Bairro(3,"Centro Alegre",c2);
	Bairro b4 = new Bairro(4,"Roça Alegre",c2);
	Bairro b5 = new Bairro(5,"Pampulha",c3);
	Bairro b6 = new Bairro(6,"Dona Clara",c3);
	Bairro b7 = new Bairro(7,"Centro Carat",c4);
	Bairro b8 = new Bairro(8,"Roça Carat",c4);
	bairroRepository.save(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8));*/
	
	
	
	}
	
}
