package dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Aluno;

public class AlunoDao extends DAOModel<Aluno> {

	public Aluno getById(int id) {
		Aluno aluno = null;

		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM alunos WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int alunoId = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				int idade = resultSet.getInt("idade");
				String email = resultSet.getString("email");
				String curso = resultSet.getString("curso");
				String cidade = resultSet.getString("cidade");
				String telefone = resultSet.getString("telefone");

				aluno = new Aluno(nome, idade, email, curso, cidade, telefone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aluno;
	}

	private Connection getConnection() {
		Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/projetojulio";
			String user = "root";
			String password = ""; // Manter vazio, pois não tem senha padrão do usuário "root"

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public Aluno update(Aluno aluno) {
		try (Connection connection = getConnection()) {
			String sql = "UPDATE alunos SET nome = ?, email = ?, idade = ?, curso = ?, cidade = ?, telefone = ? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setInt(3, aluno.getIdade());
			statement.setString(4, aluno.getCurso());
			statement.setString(5, aluno.getCidade());
			statement.setString(6, aluno.getTelefone());
			statement.setLong(7, aluno.getId());

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Aluno atualizado com sucesso!");
			} else {
				System.out.println("Nenhum aluno foi atualizado. Verifique se o ID do aluno está correto.");
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao atualizar o aluno:");
			e.printStackTrace();
		}
		return aluno;
	}
}
