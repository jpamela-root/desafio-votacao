package com.example.votacaodesafio.service;

import com.example.votacaodesafio.model.Pauta;
import com.example.votacaodesafio.repository.PautaRepository;
import com.example.votacaodesafio.service.PautaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PautaServiceTest {

    @Mock
    private PautaRepository pautaRepository;

    @InjectMocks
    private PautaService pautaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    public void deveSalvarPauta() {
        Pauta pauta = new Pauta("Teste Pauta");
        when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta); // Simula o save()

        Pauta resultado = pautaService.salvar(pauta);

        assertNotNull(resultado);
        assertEquals("Teste Pauta", resultado.getId());
        verify(pautaRepository, times(1)).save(pauta); // Verifica que o save foi chamado uma vez
    }

    @Test
    public void deveListarPautas() {
        Pauta pauta1 = new Pauta("Pauta 1");
        Pauta pauta2 = new Pauta("Pauta 2");
        List<Pauta> pautas = Arrays.asList(pauta1, pauta2);

        when(pautaRepository.findAll()).thenReturn(pautas); // Simula o findAll()

        List<Pauta> resultado = pautaService.listar();

        assertEquals(2, resultado.size());
        verify(pautaRepository, times(1)).findAll(); // Verifica que o findAll foi chamado uma vez
    }

    @Test
    public void deveBuscarPautaPorId() {
        Pauta pauta = new Pauta("Pauta Teste");
        when(pautaRepository.findById(1L)).thenReturn(Optional.of(pauta)); // Simula o findById()

        Pauta resultado = pautaService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Pauta Teste", resultado.getId());
        verify(pautaRepository, times(1)).findById(1L); // Verifica que o findById foi chamado
    }

    @Test
    public void deveLancarExcecaoQuandoPautaNaoExistir() {
        when(pautaRepository.findById(1L)).thenReturn(Optional.empty()); // Simula ausência de resultado

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pautaService.buscarPorId(1L);
        });

        assertEquals("Pauta não encontrada com o ID: 1", exception.getMessage());
        verify(pautaRepository, times(1)).findById(1L); // Verifica que o findById foi chamado
    }
}
