package com.hortfruit.authservice.authservice.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private Boolean isFornecedor;
}
