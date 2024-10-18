package com.example.votacaodesafio.service;

import com.example.votacaodesafio.model.Pauta;
import com.example.votacaodesafio.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public List<Pauta> listar() {
        return pautaRepository.findAll(); // Chama o método do repositório para listar todas as pautas
    }

    public Pauta buscarPorId(Long id) {
        return pautaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada com o ID: " + id));
    }

    public void abrirSessao(Long id, Long duracao) {
        // Implementação para abrir uma sessão
    }
}
