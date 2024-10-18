package com.example.votacaodesafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API de Votação", version = "v1", description = "Documentação da API de Votação"))
public class OpenApiConfig {
    // Outras configurações, se necessário
}
