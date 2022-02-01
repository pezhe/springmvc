package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entity.Product;
import ru.gb.service.RepositoryService;

@Controller
@RequestMapping("/repository")
@RequiredArgsConstructor
public class RepositoryController {

    private final RepositoryService service;

    @GetMapping(path = "/")
    public String getProductList(Model model) {
        model.addAttribute("list", service.getProductList());
        return "repo";
    }

    @GetMapping(path="/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping(path="/add")
    public String processForm(Product product) {
        service.add(product);
        return "redirect:/repository/";
    }

}
