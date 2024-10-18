package com.example.votacaodesafio.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    @PostMapping("/acao1")
    public ResponseEntity<String> acao1(@RequestBody FormularioRequest request) {

        // Lógica para processar a requisição
        return ResponseEntity.ok("Ação 1 executada com sucesso");
    }

    // Defina uma classe para o corpo da requisição
    public static class FormularioRequest {
        private String campo1;
        private int campo2;
        private String idCampoTexto;
        private int idCampoNumerico;
        private String idCampoData;

        // Getters e Setters
    }
}

