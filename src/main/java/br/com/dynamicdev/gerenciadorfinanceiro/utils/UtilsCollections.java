package br.com.dynamicdev.gerenciadorfinanceiro.utils;

import java.util.Collection;

public class UtilsCollections {

	/**
	 * Verifica se uma colecao e nula ou vazia
	 *
	 * @param collection
	 *            Colecao de qualquer tipo
	 * @return true se a colecao for nula ou vazia, ou false caso contrario
	 */
	public boolean checkCollectionIsNullOrEmpty(Collection<?> collection) {

		return collection == null || collection.isEmpty();
	}

	/**
	 * Verifica se uma colecao nao e nula e nao esta vazia
	 *
	 * @param collection
	 *            Colecao de qualquer tipo
	 * @return true se a colecao nao for nula e nem estiver vazia, ou false caso contrario
	 */
	public boolean checkCollectionIsNotNullAndNotEmpty(Collection<?> collection) {

		return collection != null && !collection.isEmpty();
	}

}
