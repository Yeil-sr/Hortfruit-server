package com.hortfruit.client.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private Long usuarioId;
    private String telefone;
    private Long enderecoId;
    private String nome;
    private String email;

    // Construtor sem argumentos
    public ClienteDTO() {}

    // Construtor com argumentos
    public ClienteDTO(Long id, Long usuarioId, String telefone, Long enderecoId, String nome, String email) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
        this.nome = nome;
        this.email = email;
    }

}
