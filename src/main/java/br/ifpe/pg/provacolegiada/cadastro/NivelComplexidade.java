package br.ifpe.pg.provacolegiada.cadastro;

public enum NivelComplexidade {
	BAIXA("Baixa"), MEDIA("Média"), ALTA("Alta");

	String text;

	NivelComplexidade(String t) {
		this.text = t;
	}

	public String getText() {
		return this.text;
	}
}
