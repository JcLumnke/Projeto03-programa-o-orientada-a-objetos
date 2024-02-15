package dao;

import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

public abstract class DAOModel<E> implements DAO<E> {

	public EntityManager conexaoAtual() {
		EntityManagerFactory emf = UtilJPA.efetuaConexao();
		return emf.createEntityManager();

	}

	public E insert(E objeto) {

		EntityManager transacao = conexaoAtual();
		transacao.getTransaction().begin();
		transacao.persist(objeto);
		transacao.getTransaction().commit();
		transacao.close();
		return objeto;

	}

	public E update(E objeto) {

		EntityManager transacao = conexaoAtual();
		transacao.getTransaction().begin();
		objeto = transacao.merge(objeto);
		transacao.getTransaction().commit();
		transacao.close();
		return objeto;

	}

	public E delete(Class<E> cLasse, long id) {

		EntityManager transacao = conexaoAtual();
		E objeto = transacao.find(cLasse, id);
		transacao.getTransaction().begin();
		transacao.remove(objeto);
		transacao.getTransaction().commit();
		transacao.close();
		return objeto;

	}

	public E select(Class<E> classe, long id) {
		E objeto = conexaoAtual().find(classe, id);
		return objeto;
	}

	public List<E> selectAll(Class<E> classe) {
		return (List<E>) conexaoAtual().createQuery("select t from " + classe.getSimpleName() + " t").getResultList();
	}
}
