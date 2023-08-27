package com.example.crm.controllers;

import com.example.crm.requests.ProductRequest;
import com.example.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secured")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        if (productService.addProduct(productRequest))
            return ResponseEntity.status(HttpStatus.OK).body("Success");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failure");
    }
}
