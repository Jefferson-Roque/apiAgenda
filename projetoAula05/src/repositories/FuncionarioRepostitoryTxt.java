package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;

import entities.Funcionario;

public class FuncionarioRepostitoryTxt extends FuncionarioRepository {


	
	@Override
	public void exportar(Funcionario funcionario) throws Exception {
		
		PrintWriter printWriter = new PrintWriter(new FileWriter("c:\\temp\\funcionario.txt", true));
		printWriter.write("\n" + funcionario.toString());
		printWriter.close();
	
	
	}
	
}
	
	

