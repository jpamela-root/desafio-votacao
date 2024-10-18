package com.example.votacaodesafio.repository;

import com.example.votacaodesafio.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findByPautaId(Long pautaId);

    boolean existsByPautaIdAndAssociadoId(Long pautaId, Long associadoId);
}
