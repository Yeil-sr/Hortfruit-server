package com.hortfruit.address.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos") // Correspondência com o nome da tabela no banco de dados
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = true) // Campo opcional
    private String bairro;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = true) // Campo opcional
    private String complemento;

    @Column(nullable = true) // Campo opcional
    private String referencia;

}
