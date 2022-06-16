package com.stationary.shop.services;

import com.stationary.shop.entities.Product;
import com.stationary.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo ProdRepo;
    public Product saveProduct(Product product){
        return ProdRepo.save(product);
    }
    public void updateProduct(Product product){
        ProdRepo.save(product);
    }
    public void deleteProduct(Long id){
        ProdRepo.deleteById(id);
    }
    public ProductRepo getProdRepo() {
        return ProdRepo;
    }

    public Iterable<Product> getProducts(){
        return ProdRepo.findAll();
    }
}
