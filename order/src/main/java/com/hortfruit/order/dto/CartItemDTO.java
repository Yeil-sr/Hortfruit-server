package com.hortfruit.order.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long productId;
    private Integer quantity;
    private Double price; // Preço unitário
}
