package org.ebazaar.controller;

import lombok.extern.slf4j.Slf4j;
import org.ebazaar.dto.ProductRequest;
import org.ebazaar.dto.ProductResponse;
import org.ebazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ebazaar/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = null;
        try{
            productResponse = productService.createProduct(productRequest);
        }catch (Exception exception){

        }
        if(productResponse != null){
            return new ResponseEntity<>("product created successfully with id: "+productResponse.getId(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("product not created", HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = productService.getAllProducts();
        if(products != null && !products.isEmpty()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(products, HttpStatus.CREATED);
        }
    }
}
