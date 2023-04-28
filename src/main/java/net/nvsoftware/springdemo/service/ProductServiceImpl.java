package net.nvsoftware.springdemo.service;

import net.nvsoftware.springdemo.error.ProductNotFoundException;
import net.nvsoftware.springdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    List<Product> productList = new ArrayList<>();
    @Override
    public Product save(Product product) {
        if(product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        productList.add(product);

        return product;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        return productList.stream().filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public String deleteById(String id) {
        Product prod = productList.stream().filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Generic Exception"));
        productList.remove(prod);
        return "Product wiht id:" + id + "has been deleted.";
    }


}
