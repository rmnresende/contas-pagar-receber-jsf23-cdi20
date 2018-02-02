package br.com.dynamicdev.model;

public enum SituacaoParcela {

	ABERTA("Aberta"), VENCIDA("Vencida"), QUITADA("Quitada"), CANCELADA("Cancelada");


	private String descricao;

	SituacaoParcela(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
