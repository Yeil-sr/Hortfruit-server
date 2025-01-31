package com.hortfruit.client.controller;

import com.hortfruit.client.model.Cliente;
import com.hortfruit.client.service.ClienteService;
import com.hortfruit.client.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ExternalService externalService;

    // Obter todos os clientes
    @GetMapping
    public ResponseEntity<?> getAllClientes() {
        try {
            return ResponseEntity.ok(clienteService.getAllClientes());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao obter lista de clientes.");
        }
    }

    // Criar um novo cliente
    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        try {
            // Validar usuário
            Object usuarioData = externalService.getUsuarioById(cliente.getUsuarioId());
            if (usuarioData == null) {
                return ResponseEntity.badRequest().body("Usuário não encontrado.");
            }

            // Validar endereço
            Object addressData = externalService.getAddressById(cliente.getEnderecoId());
            if (addressData == null) {
                return ResponseEntity.badRequest().body("Endereço não encontrado.");
            }

            // Criar cliente
            Cliente createdCliente = clienteService.createCliente(cliente);
            return ResponseEntity.status(201).body(createdCliente);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar cliente.");
        }
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            if (cliente == null) {
                return ResponseEntity.status(404).body("Cliente não encontrado.");
            }
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao obter cliente.");
        }
    }

    // Atualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(id, cliente);
            if (updatedCliente == null) {
                return ResponseEntity.status(404).body("Cliente não encontrado.");
            }
            return ResponseEntity.ok(updatedCliente);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar cliente.");
        }
    }

    // Deletar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        try {
            boolean isDeleted = clienteService.deleteCliente(id);
            if (!isDeleted) {
                return ResponseEntity.status(404).body("Cliente não encontrado.");
            }
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao deletar cliente.");
        }
    }
}
