package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repositorio;

	@Autowired
    private CursoRepository cursoRepository;
	
	public List<Turma> listarTodas() {
		return repositorio.findAll(Sort.by("curso.nome"));
	}
	
	public List<Turma> buscarPorCurso(Curso curso) {
		return repositorio.findByCurso(curso);
	}
	
	public Turma buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public void removerPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
	   public <S extends Turma> S salvar(S entity) throws Exception {
	        if (cursoRepository.findAll().isEmpty()) {
	            throw new Exception("Não é possível criar turmas sem cursos no sistema");
	        } else if (repositorio.verificarTurmasIguais(entity.getCurso(), entity.getEntrada(), entity.getAno(),
	                entity.getTurno()) > 0) {
	            throw new Exception("Não poderão existir duas turmas com mesmo curso, entrada, ano e turno");
	        }
	        return repositorio.saveAndFlush(entity);
	    }
	
}
