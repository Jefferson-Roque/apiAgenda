package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Funcionario;
import repositories.FuncionarioRepository;
import repositories.FuncionarioRepositoryCsv;
import repositories.FuncionarioRepostitoryTxt;

public class FuncionarioController {
	public void cadastrarFuncionario() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("ENTRE COM O NOME DO FUNCONARIO:");
			String nome = scanner.nextLine();

			System.out.println("ENTRE COM O CPF................: ");
			String cpf = scanner.nextLine();

			System.out.println("ENTRE COM A MATRICULA ................: ");
			String matricula = scanner.nextLine();

			System.out.println("ENTRE COM O SALARIO ................: ");
			Double salario = Double.parseDouble(scanner.nextLine());
			Funcionario funcionario = new Funcionario(UUID.randomUUID(), nome, cpf, matricula, salario);

			FuncionarioRepository funcionarioRepository = null;

			System.out.print("INFORME (1)TXT OU (2)CSV.......: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1: // POLIMORFISMO
				funcionarioRepository = new FuncionarioRepostitoryTxt();
				break;

			case 2: // POLIMORFISMO
				funcionarioRepository = new FuncionarioRepositoryCsv();
				break;

			default:
				throw new Exception("Opção inválida!");
			}

			funcionarioRepository.exportar(funcionario);
			System.out.println("\nDADOS GRAVADOS COM SUCESSO!");
			
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
