package com.hortfruit.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String unidade;
    
    @Column(nullable = false)
    private String cod;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Long fornecedorId; // Chave estrangeira para fornecedor

    @Lob
    private byte[] imagem; // Para armazenar a imagem
}
