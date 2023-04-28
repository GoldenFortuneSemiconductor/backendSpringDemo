package net.nvsoftware.springdemo.error;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
