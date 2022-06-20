package com.stationary.shop.repo;

import com.stationary.shop.entities.Category;
import com.stationary.shop.entities.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepo extends CrudRepository<Provider,Long> {

}
