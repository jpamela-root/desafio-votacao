package com.example.votacaodesafio.controller;

import com.example.votacaodesafio.service.CpfValidationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpf")
public class CpfValidationController {

    private final CpfValidationService cpfValidationService;

    public CpfValidationController(CpfValidationService cpfValidationService) {
        this.cpfValidationService = cpfValidationService;
    }

    @Operation(summary = "Validar CPF", description = "Verifica se o CPF é válido e seu status de votação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CPF válido e status retornado."),
            @ApiResponse(responseCode = "404", description = "CPF inválido ou incapaz de votar.")
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> validarCpf(@Parameter(description = "Número do CPF a ser validado")
                                             @PathVariable String cpf) {
        if (!cpfValidationService.isValidCpf(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF inválido");
        }

        String status = cpfValidationService.checkCpfStatus(cpf);

        if (status.equals("UNABLE_TO_VOTE")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": \"UNABLE_TO_VOTE\"}");
        }

        return ResponseEntity.ok("{\"status\": \"ABLE_TO_VOTE\"}");
    }
}
