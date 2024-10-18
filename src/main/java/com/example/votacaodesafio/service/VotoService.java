package com.example.votacaodesafio.service;

import com.example.votacaodesafio.model.Voto;
import com.example.votacaodesafio.repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    private final VotoRepository votoRepository;

    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public void receberVoto(Long pautaId, Voto voto) {
        if (votoRepository.existsByPautaIdAndAssociadoId(pautaId, voto.getAssociadoId())) {
            throw new RuntimeException("Associado já votou nesta pauta");
        }
        votoRepository.save(voto);
    }

    public List<Voto> buscarVotosPorPauta(Long pautaId) {
        return votoRepository.findByPautaId(pautaId);
    }
}
