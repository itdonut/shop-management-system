package com.example.crm.services;

import com.example.crm.entities.Provider;
import com.example.crm.requests.ProviderRequest;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();

    boolean addProvider(ProviderRequest providerRequest);

    void deleteProvider(String name);

    boolean existsProviderByName(String name);
}
