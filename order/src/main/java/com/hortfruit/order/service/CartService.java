package com.hortfruit.order.service;

import com.hortfruit.order.dto.CartItemDTO;
import com.hortfruit.order.dto.CartTotalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    public Double calculateTotal(List<CartItemDTO> items) {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public CartTotalDTO getCartTotal(Long userId, List<CartItemDTO> items) {
        Double total = calculateTotal(items);
        CartTotalDTO cartTotalDTO = new CartTotalDTO();
        cartTotalDTO.setUserId(userId);
        cartTotalDTO.setTotal(total);
        return cartTotalDTO;
    }
}
