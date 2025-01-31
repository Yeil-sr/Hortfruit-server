package com.hortfruit.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hortfruit.order.dto.CartItemDTO;
import com.hortfruit.order.dto.CartTotalDTO;
import com.hortfruit.order.service.CartService;

@RestController
@RequestMapping("/carrinho")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/total/{userId}")
    public ResponseEntity<CartTotalDTO> calculateCartTotal(@PathVariable Long userId,
                                                           @RequestBody List<CartItemDTO> items) {
        return ResponseEntity.ok(cartService.getCartTotal(userId, items));
    }
}
