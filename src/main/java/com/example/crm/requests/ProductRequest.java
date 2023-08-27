package com.example.crm.requests;

import com.example.crm.entities.Provider;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private double price;
    private String priceCurrency;
    private double quantity;
    private String unitOfQuantity;
    private int discount;
    private int providerId;
}
