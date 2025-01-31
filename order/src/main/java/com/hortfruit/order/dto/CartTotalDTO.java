package com.hortfruit.order.dto;

import lombok.Data;

@Data
public class CartTotalDTO {
    private Long userId;
    private Double total;
}
