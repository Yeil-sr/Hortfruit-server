package com.hortfruit.order.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Long userId;
    private Double total;
    private String status;
}
