package org.ebazaar.service;

import org.ebazaar.dto.ProductRequest;
import org.ebazaar.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
