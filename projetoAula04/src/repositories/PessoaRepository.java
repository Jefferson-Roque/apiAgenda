package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {

	public void inserir(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into pessoa(id, nome, cpf, telefone) values(?,?,?,?)");

		statement.setObject(1, pessoa.getId());
		statement.setString(2, pessoa.getNome());
		statement.setString(3, pessoa.getCpf());
		statement.setString(4, pessoa.getTelefone());
		statement.execute();

		connection.close();

	}

	public void editar(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("uptade pessoa set nome=?, cpf=?,telefone=?,where id=?");

		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setString(3, pessoa.getTelefone());
		statement.setObject(4, pessoa.getId());
		statement.execute();

		connection.close();

	}

	public void excluir(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from pessoa where id=?");

		statement.setObject(1, pessoa.getId());
		statement.execute();

		connection.close();

	}

	public List<Pessoa> obterTodos() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa order by nome");

		ResultSet resultSet = statement.executeQuery();

		List<Pessoa> lista = new ArrayList<Pessoa>();

		while (resultSet.next()) {

			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));

			lista.add(pessoa);
		}

		connection.close();

		return lista;
	}

	public Pessoa obterPorId(UUID id) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select* from pessoa where id=?");

		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();

		Pessoa pessoa = null;

		if (resultSet.next()) {

			pessoa = new Pessoa();
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));
		}

		connection.close();

		return pessoa;
	}

}