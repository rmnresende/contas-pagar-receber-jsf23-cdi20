package br.com.dynamicdev.gerenciadorfinanceiro.utils.jpa;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Esta e a classe que cria a conexao com o Bando de Dados.
 * Ela tem escopo de aplicação, porque seŕa criada apenas uma para toda a aplicacao
 * @author renan *
 */
@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory factory;

	// cria a conexão qdo instancia o EntityMangerProducer
	public EntityManagerProducer() {
		try {
			this.factory = Persistence.createEntityManagerFactory("GerenciadorFinanceiro_PU");
		} catch (Exception e) {
			System.out.println("ERRO NO ENTITY MANAGER PRODUCER ===========>>>>>>>" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Produces
	@RequestScoped
	public EntityManager create() {
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	// quando encerrar a requisão este método fará o fechamento do EntityManager
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}

}
