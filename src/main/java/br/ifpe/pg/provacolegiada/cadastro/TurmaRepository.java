package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	@Query("select e from Turma e where e.curso = :curso order by e.ano, e.entrada")
	public List<Turma> findByCurso(Curso curso);
	
	//Verificando se há turmas iguais
	@Query("select count(t) from Turma t where t.curso = :curso and t.entrada = :entrada and t.ano = :ano and t.turno = :turno")
	int verificarTurmasIguais(@Param("curso") Curso curso, @Param("entrada") int entrada, @Param("ano")
			int ano, @Param("turno") Turno turno);
}
