package com.example.crm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "price_currency")
    private String priceCurrency;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "unit_of_quantity")
    private String unitOfQuantity;
    @Column(name = "discount")
    private int discount;
    @Column(name = "time")
    private String time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;
}
