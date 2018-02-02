package br.com.dynamicdev.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.dynamicdev.utils.UtilsCollections;

public class ContaPagar {

	private Long id;

	private List<ParcelaPagar> parcelas;

	private BigDecimal valorTotalConta;

	private Fornecedor credor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ParcelaPagar> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaPagar> parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getValorTotalConta() {
		return valorTotalConta;
	}

	public void setValorTotalConta(BigDecimal valorTotalConta) {
		this.valorTotalConta = valorTotalConta;
	}

	public Fornecedor getCredor() {
		return credor;
	}

	public void setCredor(Fornecedor credor) {
		this.credor = credor;
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
		ContaPagar other = (ContaPagar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public BigDecimal totalPago() {

		if (new UtilsCollections().checkCollectionIsNotNullAndNotEmpty(this.parcelas)) {

			return this.parcelas.stream().filter(p -> p.isParcelaPaga()).map(p -> p.getValorLiquido())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
		}

		return BigDecimal.ZERO;
	}

	public BigDecimal totalAPagar() {

		if (new UtilsCollections().checkCollectionIsNotNullAndNotEmpty(this.parcelas)) {

			return this.parcelas.stream().filter(p -> p.isParcelaAPagar()).map(p -> p.getValorLiquido())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
		}

		return BigDecimal.ZERO;
	}

}
