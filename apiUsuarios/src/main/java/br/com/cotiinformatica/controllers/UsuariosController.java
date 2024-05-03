package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.dtos.CriarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.CriarUsuarioResponseDto;
import br.com.cotiinformatica.interfaces.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("criar")
	public ResponseEntity<CriarUsuarioResponseDto> criar(@RequestBody @Valid CriarUsuarioRequestDto dto) {

		// criando o usuário no sistema
		CriarUsuarioResponseDto response = usuarioService.criarUsuario(dto);
		// retornar status de sucesso
		return ResponseEntity.status(201).body(response);
	}

	@PostMapping("autenticar")
	public ResponseEntity<AutenticarUsuarioResponseDto> autenticar(
			@RequestBody @Valid AutenticarUsuarioRequestDto dto) {

		AutenticarUsuarioResponseDto response = usuarioService.autenticarUsuario(dto);

		return ResponseEntity.status(200).body(response);

	}

}
