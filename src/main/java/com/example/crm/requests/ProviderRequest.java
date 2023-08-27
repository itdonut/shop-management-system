package com.example.crm.requests;

import lombok.Data;

@Data
public class ProviderRequest {
    private String name;
    private String address;
    private String phone;
    private String email;
}
