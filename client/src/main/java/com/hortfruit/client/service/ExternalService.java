package com.hortfruit.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

    private final RestTemplate restTemplate;

    public ExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Obter dados do endereço pelo ID
    public Object getAddressById(Long addressId) {
        String url = "http://address-service/addresses/" + addressId;
        return restTemplate.getForObject(url, Object.class);
    }

    // Obter dados do usuário pelo ID
    public Object getUsuarioById(Long usuarioId) {
        String url = "http://auth-service/usuarios/" + usuarioId;
        return restTemplate.getForObject(url, Object.class);
    }
}
