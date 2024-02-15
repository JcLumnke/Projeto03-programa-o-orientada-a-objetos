package model;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AlunoDao;
import dao.CursoDao;

public class Principal {

	public static void main(String[] args) {

		// entrada dados teclado para main()
		Scanner s = new Scanner(System.in);

		menu(); // menu do sistema
		int opcao = 0; // opcao do menu

		System.out.println("Informe a opção desejada: ");
		opcao = s.nextInt(); // // entrando a opcao

		while (opcao != 0) {
			if (opcao > 0 && opcao <= 7) {
				switch (opcao) {
				case 1: {
					cadastraAluno();
					break;
				}
				case 2: {
					cadastraCurso();
					break;
				}

				case 3: {
					listaAlunos();
					break;
				}
				case 4: {
					listaCursos();
					break;
				}
				case 5: {
					atualizarAluno();
					break;
				}

				case 6: {

					deletarAluno();
					break;

				}

				case 7: {
					nomeEquipe();
					break;

				}
				}
			} else {
				System.out.println("Opcao inválida! ");
			}
			menu();
			System.out.println("Informe a opção desejada: ");
			opcao = s.nextInt(); // // entrando a opcao
		}
		System.out.println("Fim do programa");
	}

	private static void menu() {
		System.out.println("============== Menu do Sistema ==============");
		System.out.println("1. Cadastrar aluno");
		System.out.println("2. Cadastrar curso");
		System.out.println("3. Listar alunos cadastrados");
		System.out.println("4. Listar cursos cadastradas");
		System.out.println("5. Alterar um aluno");
		System.out.println("6. Excluir um aluno");
		System.out.println("7. Nome dos integrantes (dupla)");
		System.out.println("0. Sair");
		System.out.println("============== Menu do Sistema ==============");
	}

	private static void cadastraAluno() {
		Scanner s = new Scanner(System.in);
		AlunoDao dao = new AlunoDao();

		System.out.println("Informe o nome do aluno: \n");
		String nome = s.nextLine();

		System.out.println("Informe o e-mail do aluno: \n");
		String email = s.nextLine();

		System.out.println("Informe a idade do aluno: \n");
		int idade = s.nextInt();
		s.nextLine();

		System.out.println("Informe o curso do aluno: ");
		String curso = s.nextLine();

		System.out.println("Informe a cidade do aluno: ");
		String cidade = s.nextLine();

		System.out.println("Informe o telefone do aluno: ");
		String telefone = s.nextLine();

		Aluno aluno = new Aluno(nome, idade, email, curso, cidade, telefone);

		dao.insert(aluno);
	}

	private static void cadastraCurso() {
		Scanner s = new Scanner(System.in);
		CursoDao dao = new CursoDao();

		System.out.println("Informe o nome do curso: \n");
		String nome_curso = s.nextLine();

		System.out.println("Informe a descrição do curso: \n");
		String descricao = s.nextLine();

		System.out.println("Informe a quantidade de horas do curso: \n");
		int horas_curso = s.nextInt();
		s.nextLine();

		System.out.println("Informe o nome do professor: \n");
		String nome_Professor = s.nextLine();

		System.out.println("Informe se o curso é gratuito: \n");
		String curso_gratuito = s.nextLine();

		System.out.println("Informe se possui certificado: \n");
		String possui_certificado = s.nextLine();

		Curso curso = new Curso(nome_curso, descricao, horas_curso, nome_Professor, curso_gratuito, possui_certificado);

		dao.insert(curso);

	}

	private static void listaAlunos() {

		AlunoDao dao = new AlunoDao();

		List<Aluno> alunos = dao.selectAll(Aluno.class);

		System.out.println("Alunos cadastrados:\n");

		for (Aluno aluno : alunos) {
			System.out.println("ID: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("Curso: " + aluno.getCurso());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("--------");

		}
	}

	private static void listaCursos() {

		CursoDao dao = new CursoDao();

		List<Curso> cursos = dao.selectAll(Curso.class);

		System.out.println("Cursos cadastrados:\n");

		for (Curso curso : cursos) {

			System.out.println("ID: " + curso.getId());
			System.out.println("Nome: " + curso.getNome_curso());
			System.out.println("Descrição: " + curso.getDescricao());
			System.out.println("Horas do curso: " + curso.getHoras_curso());
			System.out.println("Nome do professor: " + curso.getNome_Professor());
			System.out.println("Curso gratuito: " + curso.getCurso_gratuito());
			System.out.println("Possui certificado: " + curso.getPossui_certificado());
			System.out.println("--------");
		}

	}

	private static void atualizarAluno() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("julioPU");
		EntityManager em = emf.createEntityManager();

		Scanner s = new Scanner(System.in);
		AlunoDao alunoDao = new AlunoDao();

		AlunoDao dao = new AlunoDao();

		List<Aluno> alunos = dao.selectAll(Aluno.class);

		System.out.println("Alunos cadastrados:\n");

		for (Aluno aluno : alunos) {
			System.out.println("ID: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("--------");

		}

		System.out.println("Informe o ID do aluno que deseja atualizar: ");
		long idAluno = s.nextLong();

		System.out.println("Novo e-mail:");
		String novoEmail = s.next();

		System.out.println("Novo telefone: ");
		String novoTelefone = s.next();
		s.nextLine();

		System.out.println("Agora, informe o novo nome");
		String novoNomeDoInfeliz = s.next();

		try {

			em.getTransaction().begin();
			Aluno aluno = em.find(Aluno.class, idAluno);

			if (aluno != null) {

				aluno.setNome(novoNomeDoInfeliz);
				aluno.setTelefone(novoTelefone);
				aluno.setEmail(novoEmail);
				em.merge(aluno);
				em.getTransaction().commit();
				System.out.println("Nome do aluno alterado com sucesso.");

			} else {

				System.out.println("Aluno não encontrado.");

			}

		} catch (Exception e) {

			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}

			System.out.println("Erro ao alterar o nome do aluno: " + e.getMessage());

		} finally {
			em.close();
			emf.close();
		}

	}

	private static void deletarAluno() {

		Scanner s = new Scanner(System.in);
		AlunoDao aln = new AlunoDao();

		List<Aluno> alunos = aln.selectAll(Aluno.class);

		System.out.println("Alunos cadastrados:\n");

		for (Aluno aluno : alunos) {
			System.out.println("ID: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("Curso: " + aluno.getCurso());
			System.out.println("--------");

		}

		System.out.println("Informe o ID do aluno que deseja deletar: ");
		long id = s.nextLong();

		aln.delete(Aluno.class, id);
	}

	private static void nomeEquipe() {
		System.out.println("Equipe: Julio Cesar Lümke e José Antônio Cipriani");

	}
}
