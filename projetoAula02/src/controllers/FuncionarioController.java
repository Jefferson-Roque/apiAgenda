package controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;
import entities.Funcionario;
import repositories.FuncionarioRepository;
public class FuncionarioController {
	
	public void cadastrarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");
			
			
			Funcionario funcionario = new Funcionario();
			funcionario.setId(UUID.randomUUID());
			
			System.out.print("INFORME O NOME...............: ");
			funcionario.setNome(scanner.nextLine());
			
			System.out.print("INFORME O CPF................: ");
			funcionario.setCpf(scanner.nextLine());
			
			System.out.print("INFORME A MATRICULA..........: ");
			funcionario.setMatricula(scanner.nextLine());
			
			System.out.print("INFORME O SALÁRIO............: ");
			funcionario.setSalario(Double.parseDouble(scanner.nextLine()));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("DATA DE ADMISSÃO (dd/MM/yyyy).:");
			funcionario.setDataAdmissao(sdf.parse(scanner.nextLine()));
			
			
			FuncionarioRepository funcionariorepository= new FuncionarioRepository();
			funcionariorepository.exportarFuncionario(funcionario);
			System.out.println("\nFUNCIONÁRIO CADASTRADO COM SUCESSO.");
		
		}
		catch(IllegalArgumentException e) {
			
			System.out.println("\nERRO NO PREENCHIMENTO DOS CAMPOS: ");
			System.out.println(e.getMessage());
		}
		catch(ParseException e) {
			
			System.out.println("\nERRO DE CONVERSÃO DE FORMATO:");
			System.out.println(e.getMessage());
		}		
		catch(Exception e) {
			
			System.out.println("\nFALHA AO CADASTRAR FUNCIONÁRIO");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
}





		
	


