package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("bundle")
public class AddBundleController {

    private final BundleService bundleService;
    private final ProductService productService;

    public AddBundleController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }

    @GetMapping("/addBundle")
    public String addBundle(Model model) {
        List<Product> products = productService.listProducts();
        model.addAttribute("bundle", new Bundle());
        model.addAttribute("products", products);
        return "addbundle";
    }

    @PostMapping("/addBundle")
    public String submitBundle(@ModelAttribute("bundle") Bundle bundle) {
        bundleService.saveBundle(bundle);
        return "confirmbundle";
    }

    @GetMapping("/addProducts")
    public String addProduct(@RequestParam("id") Long id, Model model, @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().add(product);
        bundleService.saveBundle(bundle);
        model.addAttribute("bundle", bundle);
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("productsAdded", bundle.getProducts());
        return "addbundle";
    }

    @GetMapping("/removeProducts")
    public String removeProduct(@RequestParam("id") Long id, Model model, @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().remove(product);
        bundleService.saveBundle(bundle);
        model.addAttribute("bundle", bundle);
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("productsAdded", bundle.getProducts());
        return "addbundle";
    }


}
