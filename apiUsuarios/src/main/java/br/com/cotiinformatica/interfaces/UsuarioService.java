package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.dtos.CriarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.CriarUsuarioResponseDto;

public interface UsuarioService {

	/*
	 * Método para criar usuário
	 */
	CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto);

	/*
	 * Método para autenticar usuário
	 */
	AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto);

}
