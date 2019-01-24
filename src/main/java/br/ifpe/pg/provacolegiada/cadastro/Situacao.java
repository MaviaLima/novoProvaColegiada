package br.ifpe.pg.provacolegiada.cadastro;

public enum Situacao {
	  ATIVO("Ativo"),
	  INATIVO("Inativo");

	    String text;

	    Situacao(String t) {
	        this.text = t;
	    }

	    public String getText() {
	        return this.text;
	    }
}
