package br.com.dynamicdev.gerenciadorfinanceiro.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dynamicdev.gerenciadorfinanceiro.model.Cliente;
import br.com.dynamicdev.gerenciadorfinanceiro.service.ClienteService;

@Named
@ViewScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService service;

	private List<Cliente> clientes;


	@PostConstruct
	public void init() {
		clientes = service.listarTodosClientes();
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
