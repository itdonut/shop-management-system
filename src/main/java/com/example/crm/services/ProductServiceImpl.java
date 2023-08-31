package com.example.crm.services;

import com.example.crm.additional.DateTime;
import com.example.crm.entities.Product;
import com.example.crm.entities.Provider;
import com.example.crm.repos.ProductRepository;
import com.example.crm.repos.ProviderRepository;
import com.example.crm.requests.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private DateTime dateTime;

    @Override
    public List<Product> getProducts() {
        System.err.println(dateTime.getFormattedDateTime());
        return productRepository.findAll();
    }

    @Override
    public boolean addProduct(ProductRequest productRequest) {
        try {
            Provider provider = providerRepository.findProviderById(productRequest.getProviderId()).orElse(null);
            if (provider != null) {
                Product product = new Product();
                product.setDescription(productRequest.getDescription());
                product.setDiscount(productRequest.getDiscount());
                product.setPrice(productRequest.getPrice());
                product.setTitle(productRequest.getTitle());
                product.setQuantity(productRequest.getQuantity());
                product.setUnitOfQuantity(productRequest.getUnitOfQuantity());
                product.setPriceCurrency(productRequest.getPriceCurrency());
                product.setTime(dateTime.getFormattedDateTime());
                product.setProvider(provider);

                productRepository.save(product);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
