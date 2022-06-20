package com.stationary.shop.services;

import com.stationary.shop.entities.Incom;
import com.stationary.shop.entities.Product;
import com.stationary.shop.repo.IncomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomService {
    @Autowired
    IncomRepo incomRepo;

    public List<Incom> getIncoms() {
        return (List<Incom>) incomRepo.findAll();
    }

    public IncomRepo getIncomRepo() {
        return incomRepo;
    }

    public void deleteIncom(long id) {
        incomRepo.deleteById(id);
    }

    public void saveIncom(Incom incom) {
        incomRepo.save(incom);
    }
}
