package br.com.dynamicdev.gerenciadorfinanceiro.model;

import java.math.BigDecimal;

public class Fornecedor {

	private Long id;

	private PessoaJuridica pessoaJuridica;

	private BigDecimal valorMinimoCompra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public BigDecimal getValorMinimoCompra() {
		return valorMinimoCompra;
	}

	public void setValorMinimoCompra(BigDecimal valorMinimoCompra) {
		this.valorMinimoCompra = valorMinimoCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
