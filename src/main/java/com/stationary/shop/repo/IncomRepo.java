package com.stationary.shop.repo;

import com.stationary.shop.entities.Incom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomRepo extends CrudRepository<Incom, Long> {
}
