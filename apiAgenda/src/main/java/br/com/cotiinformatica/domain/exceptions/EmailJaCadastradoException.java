package br.com.cotiinformatica.domain.exceptions;

public class EmailJaCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmailJaCadastradoException() {
		
		super("O informado ja esta cadastrado.Tente outro.");
	}
	
}
