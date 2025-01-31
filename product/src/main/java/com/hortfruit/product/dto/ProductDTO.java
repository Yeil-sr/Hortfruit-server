package com.hortfruit.product.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String nome;
    private String tipo;
    private String unidade;
    private String cod;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private Long fornecedorId;
    private byte[] imagem;
}
