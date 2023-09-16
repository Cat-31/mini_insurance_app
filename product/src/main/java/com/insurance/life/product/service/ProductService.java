package com.insurance.life.product.service;

import com.insurance.life.product.common.dto.ProductDTO;
import com.insurance.life.product.common.dto.TermDTO;
import com.insurance.life.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> queryAllProduct() {
        List<ProductDTO> products = new ArrayList<>();
        productRepository.findAll().forEach(item -> {
            products.add(new ProductDTO(item.getId(), item.getName()));
        });

        return products;
    }


    public List<TermDTO> querySupportedTerm(String productCode) {
        return productRepository.findById(productCode).get()
                .getConfig().getSupportedTerm().stream().map(
                        item -> new TermDTO(item.getTerm(), item.getDescription())
                ).collect(Collectors.toList());
    }
}
