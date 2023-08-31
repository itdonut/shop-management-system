package com.example.crm.services;

import com.example.crm.entities.Product;
import com.example.crm.entities.Provider;
import com.example.crm.requests.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    boolean addProduct(ProductRequest productRequest);
}
