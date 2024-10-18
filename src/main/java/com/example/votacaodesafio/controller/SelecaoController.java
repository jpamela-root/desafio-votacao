package com.example.votacaodesafio.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/selecao")
public class SelecaoController {

    @PostMapping
    public ResponseEntity<String> selecionar(@RequestBody SelecaoRequest request) {
        // Lógica para processar a seleção
        return ResponseEntity.ok("Seleção processada com sucesso");
    }

    // Defina uma classe para o corpo da requisição
    public static class SelecaoRequest {
        private String idOpcaoSelecionada;

        // Getters e Setters
    }
}
