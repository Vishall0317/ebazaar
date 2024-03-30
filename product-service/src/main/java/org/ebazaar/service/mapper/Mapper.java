package org.ebazaar.service.mapper;

import org.ebazaar.dto.ProductRequest;
import org.ebazaar.dto.ProductResponse;
import org.ebazaar.entity.Product;

public class Mapper {

    public static Product mapToProduct(ProductRequest productRequest) {
        return Product.builder()
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .build();
    }

    public static ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
