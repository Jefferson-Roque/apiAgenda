package entities;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {
	private UUID id;
	private String nome;
	private String cpf;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("O nome é obrigatório.");
		}

		Pattern pattern = Pattern.compile("^[A-Za-zÀ-Üà-ü\\s]{8,100}$");
		Matcher matcher = pattern.matcher(nome);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Informe um nome válido de 8 a 100 caracteres.");
		}

		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("O cpf é obrigatório.");
		}

		Pattern pattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
		Matcher matcher = pattern.matcher(cpf);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Informe o cpf no formato: '999.999.999-99'.");
		}

		this.cpf = cpf;
	}

}
