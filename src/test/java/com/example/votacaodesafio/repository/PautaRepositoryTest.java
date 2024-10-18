package com.example.votacaodesafio.repository;

import com.example.votacaodesafio.model.Pauta;
import com.example.votacaodesafio.repository.PautaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PautaRepositoryTest {

    @Autowired
    private PautaRepository pautaRepository;

    @Test
    public void deveSalvarEPesquisarPautaPorNome() {
        Pauta pauta = new Pauta("Nova Pauta");
        pautaRepository.save(pauta);

        List<Pauta> resultado = pautaRepository.findByNome("Nova Pauta");
        assertEquals(1, resultado.size());
        assertEquals("Nova Pauta", resultado.get(0).getId());
    }
}

