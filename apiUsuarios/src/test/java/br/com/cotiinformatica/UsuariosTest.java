package br.com.cotiinformatica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Locale;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import br.com.cotiinformatica.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.dtos.CriarUsuarioRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuariosTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	// atributos para armazenar os dados
	// do usuário cadastrado no primeiro teste
	private static String nome;
	private static String email;
	private static String senha;

	@Test
	@Order(1)
	public void quandoCriarUsuario_entaoRetornarStatus201() throws Exception {

		Faker faker = new Faker(new Locale("pt-BR"));

		CriarUsuarioRequestDto dto = new CriarUsuarioRequestDto();
		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setSenha("@Teste123");

		mockMvc.perform(post("/api/usuarios/criar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isCreated());

		nome = dto.getNome();
		email = dto.getEmail();
		senha = dto.getSenha();
	}

	@Test
	@Order(2)
	public void quandoCriarUsuarioComEmailJaCadastrado_entaoRetornarStatus422() throws Exception {

		CriarUsuarioRequestDto dto = new CriarUsuarioRequestDto();
		dto.setNome(nome);
		dto.setEmail(email);
		dto.setSenha(senha);

		mockMvc.perform(post("/api/usuarios/criar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isUnprocessableEntity());
	}

	@Test
	@Order(3)
	public void quandoAutenticarUsuario_entaoRetornarStatus200() throws Exception {

		AutenticarUsuarioRequestDto dto = new AutenticarUsuarioRequestDto();
		dto.setEmail(email);
		dto.setSenha(senha);

		mockMvc.perform(post("/api/usuarios/autenticar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isOk());
	}

	@Test
	@Order(4)
	public void quandoAutenticarUsuarioInvalido_entaoRetornarStatus401() throws Exception {

		AutenticarUsuarioRequestDto dto = new AutenticarUsuarioRequestDto();
		dto.setEmail(email);
		dto.setSenha("@Teste4321");

		mockMvc.perform(post("/api/usuarios/autenticar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isUnauthorized());
	}
}
