package br.com.dynamicdev.model.interfaces;

import java.math.BigDecimal;

public interface Parcela {

	public boolean isParcelaPaga();

	public boolean isParcelaVencida();

	public boolean isParcelaCancelada();

	public BigDecimal getValorLiquido();
}
