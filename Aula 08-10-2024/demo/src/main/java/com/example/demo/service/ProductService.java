package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public Product insert(Product product){
        return repo.save(product);
    }

    public Optional<Product> findById(int cod){
        return repo.findById(cod);
    }
}
