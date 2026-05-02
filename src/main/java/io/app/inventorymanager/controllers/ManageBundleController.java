package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ManageBundleController {

    private final BundleService bundleService;
    private final ProductService productService;

    public ManageBundleController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }

    @GetMapping("/manageBundle")
    public String manageBundle(@RequestParam("id") Long id, Model model) {
        Bundle bundle = new Bundle();
        List<Product> products = productService.listProducts();
        if (bundleService.getBundleById(id).isPresent()) {
            bundle = bundleService.getBundleById(id).get();
        }
        model.addAttribute("bundle", bundle);
        model.addAttribute("products", products);
        return "managebundle";
        }

    @PostMapping("/manageBundle")
    public String updateBundle(@ModelAttribute("bundle") Bundle bundle) {
        bundleService.updateBundle(bundle);
        return "bundleupdated";
    }

    @GetMapping("/deleteBundle")
    public String deleteBundle(@RequestParam("id") Long id) {
        bundleService.deleteById(id);
        return "deletebundle";
    }
}
