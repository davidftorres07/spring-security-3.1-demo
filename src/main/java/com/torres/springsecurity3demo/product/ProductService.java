package com.torres.springsecurity3demo.product;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @PostConstruct
    public void loadProductsFromDb() {
        productList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Product.builder()
                        .id(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(20))
                        .price(new Random().nextInt(5000))
                        .build()
                ).collect(Collectors.toList());
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProductByID(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException(String.format("Product with ID %d not found.", id)));
    }
}
