package br.com.dynamicdev.gerenciadorfinanceiro.model.interfaces;

import java.math.BigDecimal;

public interface Parcela {

	public boolean isParcelaPaga();

	public boolean isParcelaVencida();

	public boolean isParcelaCancelada();

	public BigDecimal getValorLiquido();
}
