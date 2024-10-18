package com.example.votacaodesafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0", description = "API para gestão de itens"))
public class VotacaoDesafioApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotacaoDesafioApplication.class, args);
    }
}
