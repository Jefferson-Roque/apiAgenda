package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	/*
	 * Método para consultar 1 usuário através de um email informado
	 */
	@Query("from Usuario u where u.email = :email")
	Usuario findByEmail(@Param("email") String email);

	/*
	 * Método para consultar 1 usuário através de um email e senha informado
	 */
	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	Usuario findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
