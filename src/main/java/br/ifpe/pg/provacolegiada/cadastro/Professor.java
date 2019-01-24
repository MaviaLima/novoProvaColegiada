package br.ifpe.pg.provacolegiada.cadastro;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Professor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
		
	@Enumerated(EnumType.STRING)
	private AreasPesquisa areasPesquisa;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	@JoinColumn(name = "professor_id")
	private Set<Curso> cursos = new HashSet<>();

	
	public Professor() {
		super();
	}
	
	public Professor(Integer id, String nome, String email, AreasPesquisa areasPesquisa, Set<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.areasPesquisa = areasPesquisa;
		this.cursos = cursos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public AreasPesquisa getAreasPesquisa() {
		return areasPesquisa;
	}

	public void setAreasPesquisa(AreasPesquisa areasPesquisa) {
		this.areasPesquisa = areasPesquisa;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Professor professor = (Professor) o;
		return Objects.equals(id, professor.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return nome;
	}

}
