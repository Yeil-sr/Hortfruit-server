package com.hortfruit.client.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Referência ao ID do Usuario (Auth Service)
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    // Referência ao ID do Address (Address Service)
    @Column(name = "endereco_id", nullable = false)
    private Long enderecoId;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;
}
