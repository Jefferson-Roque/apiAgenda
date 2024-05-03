package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	
	
	@Size (min = 8,max = 100,message = "Por favor, informe de 8 a 100 carcteres.")
	@NotBlank(message = "Por favor, informe o nome do usuario.")
	private String nome;
	
	@Email (message = "Por favor, informe um endereço de email valido.")
	@NotBlank(message = "Por favor, informe o email do usuario.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
	message = "Por favor, informe a senha com letras maiúsculas, minúsculas, números, símbolos e pelo menos 8 caracteres.")
		
	@NotBlank(message = "Por favor, informe a senha do usuario.")
	private String senha;
	
}
