package com.example.crm.services;

import com.example.crm.entities.Provider;
import com.example.crm.repos.ProviderRepository;
import com.example.crm.requests.ProviderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public boolean addProvider(ProviderRequest providerRequest) {
        Provider provider = new Provider();
        provider.setName(providerRequest.getName());
        provider.setEmail(providerRequest.getEmail());
        provider.setPhone(providerRequest.getPhone());
        provider.setAddress(providerRequest.getAddress());

        try {
            providerRepository.save(provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteProvider(String name) {
        Optional<Provider> provider = providerRepository.findProviderByName(name);
        provider.ifPresent(value -> providerRepository.delete(value));
    }

    @Override
    public boolean existsProviderByName(String name) {
        return providerRepository.existsProviderByName(name);
    }
}
