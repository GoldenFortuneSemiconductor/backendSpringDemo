package net.nvsoftware.springdemo.service;

import net.nvsoftware.springdemo.entity.ProductEntity;
import net.nvsoftware.springdemo.model.Product;
import net.nvsoftware.springdemo.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplV2 implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        if(product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> productList = productEntityList.stream()
                .map(productEntity -> {
                    Product product = new Product();
                    BeanUtils.copyProperties(productEntity, product);
                    return product;
                }).collect(Collectors.toList());
        return productList;
    }

    @Override
    public Product getById(String id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    @Override
    public String deleteById(String id) {
        productRepository.deleteById(id);
        return "Product wiht id:" + id + "has been deleted with JPA H2 db.";
    }
}
