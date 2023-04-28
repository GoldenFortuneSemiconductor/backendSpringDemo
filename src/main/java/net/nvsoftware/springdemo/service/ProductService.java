package net.nvsoftware.springdemo.service;

import net.nvsoftware.springdemo.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    List<Product> getAll();
    Product getById(String id);

    String deleteById(String id);
}
