package br.com.dynamicdev.gerenciadorfinanceiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.dynamicdev.gerenciadorfinanceiro.model.interfaces.Parcela;

public class ParcelaReceber implements Parcela {

	private Long id;

	private int numero;

	private ContaReceber contaReceber;

	private LocalDate dataVencimento;

	private LocalDate dataPagamento;

	private BigDecimal valorBruto;

	private BigDecimal acrescimoDesconto;

	private SituacaoParcela situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getAcrescimoDesconto() {
		return acrescimoDesconto;
	}

	public void setAcrescimoDesconto(BigDecimal desconto) {
		this.acrescimoDesconto = desconto;
	}

	public SituacaoParcela getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoParcela situacao) {
		this.situacao = situacao;
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
		ParcelaReceber other = (ParcelaReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public boolean isParcelaPaga() {
		return this.situacao.equals(SituacaoParcela.QUITADA);
	}

	@Override
	public boolean isParcelaVencida() {
		return this.situacao.equals(SituacaoParcela.VENCIDA);
	}

	@Override
	public boolean isParcelaCancelada() {
		return this.situacao.equals(SituacaoParcela.CANCELADA);
	}

	@Override
	public BigDecimal getValorLiquido() {

		if (this.valorBruto == null) {
			return BigDecimal.ZERO;
		}

		if (this.acrescimoDesconto == null) {
			return this.valorBruto;
		}

		return this.valorBruto.add(acrescimoDesconto);
	}

	public boolean isParcelaAReceber() {
		return !isParcelaCancelada() && !isParcelaPaga();
	}
}
