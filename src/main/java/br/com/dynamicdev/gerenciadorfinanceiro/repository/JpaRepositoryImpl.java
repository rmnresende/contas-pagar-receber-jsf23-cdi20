package br.com.dynamicdev.gerenciadorfinanceiro.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class JpaRepositoryImpl<T, ID extends Serializable> implements JpaRepository<T, Serializable> {

	@Inject
	private EntityManager manager;

	private Class<T> classeEntidade;

	@SuppressWarnings("unchecked")
	public JpaRepositoryImpl() {

		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public List<T> listarTodos() {

		Session session = manager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(classeEntidade);
		Root<T> root = criteriaQuery.from(classeEntidade);
		criteriaQuery.select(root);

		TypedQuery<T> query = manager.createQuery(criteriaQuery);

		return query.getResultList();
	}

	private Field getId() throws Exception {

		Class<T> classe = classeEntidade;
		Field id;

		try {
			id = classe.getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			throw new Exception("A entidade não possui o atributo Id!");
		}

		return id;
	}

	private boolean isNovaEntidade(Field id) throws Exception{

		id.setAccessible(true);
		Object fieldType = id.getType();
		Object valor = id.get(fieldType);

		return valor == null;
	}

	@Override
	public T salvar(T entidade) throws Exception {

		Field id = getId();

		if(isNovaEntidade(id)) {
			manager.persist(entidade);
			return entidade;
		}

		return manager.merge(entidade);
	}

	@Override
	public void remover(Serializable id) throws Exception {
		T entidade = recuperarPeloId(id);
		manager.remove(entidade);
	}

	@Override
	public T recuperarPeloId(Serializable id) throws Exception {

		if (id == null) {
			throw new Exception("Id não pode ser nulo!");
		}

		return manager.find(classeEntidade, id);
	}

}
