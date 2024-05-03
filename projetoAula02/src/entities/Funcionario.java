package entities;

import java.util.Date;

public class Funcionario extends Pessoa {
	private String matricula;
	private Double salario;
	private Date dataAdmissao;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {

		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException("A matricula é obrigatória.");
		}

		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {

		if (salario <= 0) {
			throw new IllegalArgumentException("O Salário deve ser maior do que zero.");
		}

		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
