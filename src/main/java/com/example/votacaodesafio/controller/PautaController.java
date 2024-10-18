package com.example.votacaodesafio.controller;

import com.example.votacaodesafio.model.Pauta;
import com.example.votacaodesafio.service.PautaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Operation(summary = "Criar uma nova pauta", description = "Recebe os dados da pauta e a salva no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pauta criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na validação dos dados da pauta.")
    })
    @PostMapping
    public ResponseEntity<Pauta> criarPauta(@Parameter(description = "Objeto contendo os dados da pauta")
                                            @RequestBody Pauta pauta) {
        return ResponseEntity.ok(pautaService.salvar(pauta));
    }

    @Operation(summary = "Listar todas as pautas", description = "Retorna uma lista de todas as pautas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pautas retornada com sucesso.")
    })
    @GetMapping
    public ResponseEntity<List<Pauta>> listarPautas() {
        List<Pauta> pautas = pautaService.listar();
        return ResponseEntity.ok(pautas);
    }

    @Operation(summary = "Buscar pauta por ID", description = "Retorna uma pauta específica com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pauta encontrada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Pauta não encontrada.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pauta> buscarPautaPorId(@Parameter(description = "ID da pauta a ser buscada")
                                                  @PathVariable Long id) {
        Pauta pauta = pautaService.buscarPorId(id);
        return ResponseEntity.ok(pauta);
    }

    @Operation(summary = "Abrir sessão para uma pauta", description = "Abre uma sessão para votação da pauta especificada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sessão aberta com sucesso."),
            @ApiResponse(responseCode = "404", description = "Pauta não encontrada.")
    })
    @PostMapping("/{id}/abrir-sessao")
    public ResponseEntity<?> abrirSessao(@Parameter(description = "ID da pauta para a qual a sessão está sendo aberta")
                                         @PathVariable Long id,
                                         @Parameter(description = "Duração da sessão em minutos (opcional)")
                                         @RequestParam(required = false) Long duracao) {
        pautaService.abrirSessao(id, duracao);
        return ResponseEntity.ok("Sessão aberta");
    }
}
