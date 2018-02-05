package br.com.dynamicdev.gerenciadorfinanceiro.repository;

import java.io.Serializable;
import java.util.List;

public interface JpaRepository<T, ID extends Serializable> {

	List<T> listarTodos();

	T recuperarPeloId(ID id) throws Exception;

	T salvar(T entidade) throws Exception;

	void remover(ID id) throws Exception;
}
