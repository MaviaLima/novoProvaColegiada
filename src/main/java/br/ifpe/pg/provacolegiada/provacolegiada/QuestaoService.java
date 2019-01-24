package br.ifpe.pg.provacolegiada.provacolegiada;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.pg.provacolegiada.provacolegiada.Questao;
import br.ifpe.pg.provacolegiada.provacolegiada.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repositorio;
	
	public List<Questao> listarTodas() {
		return repositorio.findAll();
	}

	public Questao buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Questao salvar(Questao questao) {
		return repositorio.saveAndFlush(questao);
	}

	public Questao removerPorId(Integer id) {
		Questao questao = buscarPorId(id);
		repositorio.deleteById(id);
		return questao;
	}

}
