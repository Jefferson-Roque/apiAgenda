package br.com.cotiinformatica.services;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.components.CryptoComponent;
import br.com.cotiinformatica.components.TokenComponent;
import br.com.cotiinformatica.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.dtos.CriarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.CriarUsuarioResponseDto;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.interfaces.UsuarioService;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CryptoComponent cryptoComponent;

	@Autowired
	private TokenComponent tokenComponent;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto) {

		// verificar se já existe um usuário no banco de dados com o email informado
		if (usuarioRepository.findByEmail(dto.getEmail()) != null) {
			throw new EmailJaCadastradoException();
		}

		// copiando os dados do DTO para a entidade Usuario
		Usuario usuario = modelMapper.map(dto, Usuario.class);
		usuario.setId(UUID.randomUUID());
		usuario.setSenha(cryptoComponent.sha256Encrypt(dto.getSenha()));

		// gravar o usuário no banco de dados
		usuarioRepository.save(usuario);

		// copiando os dados da entidade Usuario para o DTO
		CriarUsuarioResponseDto response = modelMapper.map(usuario, CriarUsuarioResponseDto.class);
		response.setDataHoraCadastro(new Date());

		return response;
	}

	@Override
	public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto) {

		// consultar o usuário no banco de dados através do email e da senha
		Usuario usuario = usuarioRepository.findByEmailAndSenha(dto.getEmail(),
				cryptoComponent.sha256Encrypt(dto.getSenha()));

		// verificar se o usuário não foi encontrado
		if (usuario == null) {
			throw new AcessoNegadoException();
		}

		AutenticarUsuarioResponseDto response = modelMapper.map(usuario, AutenticarUsuarioResponseDto.class);
		response.setDataHoraAcesso(new Date());
		response.setToken(tokenComponent.generateToken(usuario.getId()));

		return response;
	}

}
