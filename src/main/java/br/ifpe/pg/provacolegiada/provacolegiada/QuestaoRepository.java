package br.ifpe.pg.provacolegiada.provacolegiada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}
