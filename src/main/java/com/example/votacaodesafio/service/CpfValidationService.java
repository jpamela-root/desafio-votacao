package com.example.votacaodesafio.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CpfValidationService {

    // Simulando um validador de CPF
    public boolean isValidCpf(String cpf) {
        // Aqui você pode usar um regex ou outro método de validação
        // Para simplificação, estamos retornando verdadeiro para todos os CPFs
        return cpf.matches("\\d{11}"); // Um CPF válido deve ter 11 dígitos
    }

    // Simulando se o CPF está apto a votar
    public String checkCpfStatus(String cpf) {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "ABLE_TO_VOTE";
        } else {
            return "UNABLE_TO_VOTE";
        }
    }
}
