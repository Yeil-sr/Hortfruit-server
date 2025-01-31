package com.hortfruit.address.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String bairro;
    private String complemento;
    private String referencia;
   
}
