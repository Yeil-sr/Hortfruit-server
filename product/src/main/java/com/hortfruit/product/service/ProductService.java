package com.hortfruit.product.service;

import com.hortfruit.product.dto.ProductDTO;
import com.hortfruit.product.model.Product;
import com.hortfruit.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getProductsByFornecedorId(Long fornecedorId) {
        return productRepository.findByFornecedorId(fornecedorId);
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setTipo(productDTO.getTipo());
        product.setUnidade(productDTO.getUnidade());
        product.setCod(productDTO.getCod());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setQuantidade(productDTO.getQuantidade());
        product.setFornecedorId(productDTO.getFornecedorId());
        product.setImagem(productDTO.getImagem());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = getProductById(id);
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setQuantidade(productDTO.getQuantidade());
        product.setFornecedorId(productDTO.getFornecedorId());
        product.setImagem(productDTO.getImagem());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
