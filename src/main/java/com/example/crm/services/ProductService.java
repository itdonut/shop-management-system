package com.example.crm.services;

import com.example.crm.entities.Product;
import com.example.crm.entities.Provider;
import com.example.crm.repos.ProductRepository;
import com.example.crm.repos.ProviderRepository;
import com.example.crm.requests.ProductRequest;
import com.example.crm.requests.ProviderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProviderRepository providerRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public boolean addProduct(ProductRequest productRequest) {
        try {
            Provider provider = providerRepository.findProviderById(productRequest.getProviderId()).orElse(null);
            if (provider != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                Product product = this.createProduct(productRequest, provider, dtf.format(now));
                productRepository.save(product);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private Product createProduct(ProductRequest productRequest, Provider provider, String time) {
        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setDiscount(productRequest.getDiscount());
        product.setPrice(productRequest.getPrice());
        product.setTitle(productRequest.getTitle());
        product.setQuantity(productRequest.getQuantity());
        product.setUnitOfQuantity(productRequest.getUnitOfQuantity());
        product.setPriceCurrency(productRequest.getPriceCurrency());
        product.setTime(time);
        product.setProvider(provider);

        return product;
    }
}
