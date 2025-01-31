package com.hortfruit.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hortfruit.order.dto.OrderDTO;
import com.hortfruit.order.model.Order;
import com.hortfruit.order.service.OrderService;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            // Verifica se o valor total foi enviado
            if (orderDTO.getTotal() == null) {
                return ResponseEntity.badRequest().body("Valor total é obrigatório");
            }

            // Cria o pedido
            Order createdOrder = orderService.createOrder(orderDTO);
            return ResponseEntity.status(201).body(createdOrder);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar pedido: " + e.getMessage());
        }
    }

    @PutMapping("/{orderId}/update")
    public ResponseEntity<?> updateOrder(@PathVariable Long orderId, @RequestBody OrderDTO orderDTO) {
        try {
            Optional<Order> updatedOrder = Optional.empty();
            if (updatedOrder.isPresent()) {
                return ResponseEntity.ok("Pedido atualizado com sucesso");
            } else {
                return ResponseEntity.status(404).body("Pedido não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar pedido: " + e.getMessage());
        }
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        try {
            boolean isCanceled = orderService.cancelOrder(orderId);
            if (isCanceled) {
                return ResponseEntity.ok("Pedido cancelado com sucesso");
            } else {
                return ResponseEntity.status(404).body("Pedido não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cancelar pedido: " + e.getMessage());
        }
    }
}
