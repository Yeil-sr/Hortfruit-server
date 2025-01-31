package com.hortfruit.supplier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fornecedor") // Mantém a consistência com o nome da tabela no banco de dados
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Long enderecoId; // Referência à chave estrangeira endereco_id

    @Column(nullable = false)
    private Long usuarioId; // Referência à chave estrangeira usuario_id

    @Column(nullable = false)
    private String nomeLoja;

    @Column(columnDefinition = "TEXT")
    private String descricaoLoja;

    @Lob
    @Column
    private byte[] logoLoja; // Armazena a logo como BLOB (byte array)
}
