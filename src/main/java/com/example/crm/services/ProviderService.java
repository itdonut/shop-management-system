package com.example.crm.services;

import com.example.crm.entities.Provider;
import com.example.crm.repos.ProviderRepository;
import com.example.crm.requests.ProviderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public boolean addProvider(ProviderRequest providerRequest) {
        try {
            Provider provider = new Provider();
            provider.setName(providerRequest.getName());
            provider.setEmail(providerRequest.getEmail());
            provider.setPhone(providerRequest.getPhone());
            provider.setAddress(providerRequest.getAddress());

            providerRepository.save(provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteProvider(String name) {
        Optional<Provider> provider = providerRepository.findProviderByName(name);
        provider.ifPresent(value -> providerRepository.delete(value));
    }

    public boolean existsProviderByName(String name) {
        return providerRepository.existsProviderByName(name);
    }
}
