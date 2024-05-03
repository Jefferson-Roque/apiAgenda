package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutenticarUsuarioRequestDto {

	@Email(message = "Por favor, informe um endereço de email valido.")
	@NotBlank(message = "Por favor, informe o email do usuario.")
	private String email;

	@Size(min = 8, message = "Por favor,informe a senha com pelo menos 8 caracteres.")
	@NotBlank(message = "Por favor, informe a senha do usuario.")
	private String senha;
}
