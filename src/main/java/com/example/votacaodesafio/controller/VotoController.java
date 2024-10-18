package com.example.votacaodesafio.controller;

import com.example.votacaodesafio.model.Voto;
import com.example.votacaodesafio.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas/{pautaId}/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @Operation(summary = "Registrar um voto", description = "Recebe um voto para a pauta especificada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voto registrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na validação do voto."),
            @ApiResponse(responseCode = "404", description = "Pauta não encontrada.")
    })
    @PostMapping
    public ResponseEntity<?> votar(
            @Parameter(description = "ID da pauta à qual o voto está sendo registrado")
            @PathVariable Long pautaId,
            @Parameter(description = "Objeto contendo os dados do voto")
            @RequestBody Voto voto) {

        votoService.receberVoto(pautaId, voto);
        return ResponseEntity.ok("Voto registrado");
    }
}

