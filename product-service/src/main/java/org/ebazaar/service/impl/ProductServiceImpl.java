package org.ebazaar.service.impl;

import org.ebazaar.dto.ProductRequest;
import org.ebazaar.dto.ProductResponse;
import org.ebazaar.entity.Product;
import org.ebazaar.repository.ProductRepository;
import org.ebazaar.service.ProductService;
import org.ebazaar.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productRepository.save(Mapper.mapToProduct(productRequest));
        return Mapper.mapToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Mapper::mapToProductResponse).collect(Collectors.toList());
    }
}
