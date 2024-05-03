package br.com.cotiinformatica.exceptions;

public class EmailJaCadastradoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailJaCadastradoException () {
		
		
		super("O email informado ja esta cadastrado.Tente outro ");
	}
	
	
}
