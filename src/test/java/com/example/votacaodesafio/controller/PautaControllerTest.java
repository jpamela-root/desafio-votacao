package com.example.votacaodesafio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PautaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornarListaDePautas() throws Exception {
        mockMvc.perform((RequestBuilder) get("/api/pautas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2)); // Exemplo para verificar se o retorno tem 2 pautas
    }
}
