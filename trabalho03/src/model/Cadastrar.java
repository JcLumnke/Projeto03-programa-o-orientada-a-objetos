package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Cadastrar {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("julioPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Criação do objeto Aluno
		Aluno aluno = new Aluno();
		aluno.setNome("João");
		aluno.setIdade(20);
		aluno.setEmail("joao@senai.com.br");
		aluno.setCurso("Lógica de programação");
		aluno.setCidade("Blumenau");
		aluno.setTelefone("3323- 1266");

		// Iniciando a transação
		entityManager.getTransaction().begin();

		// Salvando o objeto Aluno no banco de dados
		entityManager.persist(aluno);

		// Finalizando a transação
		entityManager.getTransaction().commit();

		// Fechando o EntityManager
		entityManager.close();
		entityManagerFactory.close();

		// Criação do objeto Curso
		Curso curso = new Curso();
		curso.setNome_curso("Programação Java");
		curso.setDescricao("Curso avançado de Java");
		curso.setHoras_curso(140);
		curso.setNome_Professor("Claudia Soares");
		curso.setCurso_gratuito(0);
		curso.setPossui_certificado(0);

		// Iniciando a transação
		entityManager.getTransaction().begin();

		// Salvando o objeto Curso no banco de dados
		entityManager.persist(curso);

		// Finalizando a transação
		entityManager.getTransaction().commit();

		// Fechando o EntityManager
		entityManager.close();
		entityManagerFactory.close();
	}
}
