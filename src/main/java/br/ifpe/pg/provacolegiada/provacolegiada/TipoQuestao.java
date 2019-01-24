package br.ifpe.pg.provacolegiada.provacolegiada;

public enum TipoQuestao {

	//ABERTA, 	MULTIPLA_ESCOLHA,	VERDADEIRO_FALSO
	
	ABERTA("Aberta"),
	MULTIPLA_ESCOLHA("Multipla escolha"),
	VERDADEIRO_FALSO("Verdadeiro e falso");

	String text;

	TipoQuestao(String t) {
		this.text = t;
	}

	public String getText() {
		return this.text;
	}
	 
}
