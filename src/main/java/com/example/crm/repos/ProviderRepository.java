package com.example.crm.repos;

import com.example.crm.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    boolean existsProviderByName(String name);
    Optional<Provider> findProviderByName(String name);
    Optional<Provider> findProviderById(int id);
}
