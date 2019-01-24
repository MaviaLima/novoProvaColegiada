package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

	@Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Topico buscarPorId(Integer id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public <S extends Topico> S salvar(S entity) {
        return topicoRepository.saveAndFlush(entity);
    }

    public void removerPorId(Integer id) {
        topicoRepository.deleteById(id);
    }
}
