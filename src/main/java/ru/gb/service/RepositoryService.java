package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RepositoryService {

    private final ProductRepository repo;

    public Product get(long id) {
        return repo.get(id).orElseThrow(NoSuchElementException::new);
    }

    public Product add(Product product) {
        return repo.add(product);
    }

    public List<Product> getProductList() {
        return repo.getProductList();
    }

}
