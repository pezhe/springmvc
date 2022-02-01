package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repo")
public class ProductRepository {

    private long idCounter;
    private final List<Product> productList = new ArrayList<>();

    public Optional<Product> get(long id) {
        return productList
                .stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

    public Product add(String title, double cost) {
        Product product = new Product(++idCounter, title, cost);
        productList.add(product);
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
