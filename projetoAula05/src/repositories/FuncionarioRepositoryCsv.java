package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;

import entities.Funcionario;

public class FuncionarioRepositoryCsv extends FuncionarioRepository {
	@Override
	public void exportar(Funcionario funcionario) throws Exception {
		PrintWriter printWriter = new PrintWriter(new FileWriter("c:\\temp\\funcionario.csv", true));

		printWriter.write(funcionario.getId() + ";" + funcionario.getNome() + ";" + funcionario.getCpf() + ";"
				+ funcionario.getMatricula() + ";" + funcionario.getSalario() + "\n");

		printWriter.close();
	}

}
