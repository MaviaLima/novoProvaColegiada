package br.ifpe.pg.provacolegiada.cadastro;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turma {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Curso curso;
	@Enumerated(EnumType.STRING)
	private Turno turno;
	private int ano;
	private int entrada;	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public Turma() {
		super();
	}
	
	
	public Turma(Integer id, Curso curso, Turno turno, int ano, int entrada, Situacao situacao) {
		super();
		this.id = id;
		this.curso = curso;
		this.turno = turno;
		this.ano = ano;
		this.entrada = entrada;
		this.situacao = situacao;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getEntrada() {
		return entrada;
	}
	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
}
