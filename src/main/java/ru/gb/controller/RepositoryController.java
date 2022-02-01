package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entity.Product;
import ru.gb.service.RepositoryService;

@Controller
@RequestMapping("/repository")
@RequiredArgsConstructor
public class RepositoryController {

    private final RepositoryService service;

    public String getProductList(Model model) {
        model.addAttribute("list", service.getProductList());
        return "repo";
    }

    //добавление продукта /repository/add
    @GetMapping(path="/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

}
