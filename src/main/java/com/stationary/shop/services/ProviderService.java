package com.stationary.shop.services;

import com.stationary.shop.entities.Provider;
import com.stationary.shop.repo.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    ProviderRepo providerRepo;

    public Iterable<Provider> getProviders() {
        return providerRepo.findAll();
    }

    public void saveProvider(Provider provider) {
        providerRepo.save(provider);
    }

    public void deleteProvider(long id) {
        providerRepo.deleteById(id);
    }

    public ProviderRepo getProviderRepo() {
        return providerRepo;
    }
}
