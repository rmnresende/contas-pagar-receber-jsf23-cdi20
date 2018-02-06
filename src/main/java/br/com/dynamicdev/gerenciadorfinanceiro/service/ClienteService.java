package br.com.dynamicdev.gerenciadorfinanceiro.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.dynamicdev.gerenciadorfinanceiro.model.Cliente;
import br.com.dynamicdev.gerenciadorfinanceiro.repository.ClienteRepository;


public class ClienteService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository repository;


	public List<Cliente> listarTodosClientes() {

		return repository.listarTodos();
	}

}
