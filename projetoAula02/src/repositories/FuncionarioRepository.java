package repositories;

import java.io.PrintWriter;

import entities.Funcionario;

public class FuncionarioRepository {

	public void exportarFuncionario(Funcionario funcionario) throws Exception {

		PrintWriter printWriter = new PrintWriter("c:\\temp\\funcionario.xml");

		printWriter.write("<?xml version='1.0' encoding='iso-8859-1'?>");
		printWriter.write("<funcionario>");
		printWriter.write("<id>" + funcionario.getId() + "</id>");
		printWriter.write("<nome>" + funcionario.getNome() + "</nome>");
		printWriter.write("<cpf>" + funcionario.getCpf() + "</cpf>");
		printWriter.write("<matricula>" + funcionario.getMatricula() + "</matricula>");
		printWriter.write("<salario>" + funcionario.getSalario() + "</salario>");
		printWriter.write("<dataAdmissao>" + funcionario.getDataAdmissao() + "</dataAdmissao>");
		printWriter.write("</funcionario>");

		printWriter.close();
	}
}
