package com.hortfruit.product.repository;

import com.hortfruit.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByFornecedorId(Long fornecedorId);
}
