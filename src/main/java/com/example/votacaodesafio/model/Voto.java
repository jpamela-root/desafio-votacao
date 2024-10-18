package com.example.votacaodesafio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long associadoId;

    private Boolean voto;

    @ManyToOne
    private Pauta pauta;
}
