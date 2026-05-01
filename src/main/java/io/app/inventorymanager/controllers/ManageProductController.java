package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ManageProductController {

    private final ProductService productService;

    public ManageProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/manageProduct")
    public String manageProduct(@RequestParam(name = "id") Long id, Model model) {
        Product product = new Product();
        if (productService.getProductById(id).isPresent()) {
            product = productService.getProductById(id).get();
        }
        model.addAttribute("product", product);
        return "manageproduct";
    }

    @PostMapping("/manageProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        return "productupdated";
    }
}
