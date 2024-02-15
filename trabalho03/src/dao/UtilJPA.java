package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class UtilJPA {

	private static EntityManagerFactory conexao;

	public static EntityManagerFactory efetuaConexao() {

		if (conexao == null) {
			conexao = Persistence.createEntityManagerFactory("julioPU");

		}
		return conexao;
	}

}
