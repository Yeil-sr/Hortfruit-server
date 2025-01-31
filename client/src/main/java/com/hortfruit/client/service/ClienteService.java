package com.hortfruit.client.service;

import com.hortfruit.client.model.Cliente;
import com.hortfruit.client.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        // Salvar o cliente no banco de dados
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        // Buscar cliente pelo ID
        return clienteRepository.findById(id).orElse(null);
    }

    public Iterable<Cliente> getAllClientes() {
        // Obter todos os clientes
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
