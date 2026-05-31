package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("bundle")
@RequestMapping("/manageBundle")
public class ManageBundleController {

    private final BundleService bundleService;
    private final ProductService productService;

    public ManageBundleController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }

    @GetMapping
    public String manageBundle(@RequestParam("id") Long id, Model model) {
        Bundle bundle;
        if (bundleService.getBundleById(id).isPresent()) {
            bundle = bundleService.getBundleById(id).get();
        }
        else {
            return "redirect:/homepage";
        }
        model.addAttribute("bundle", bundle);
        return "managebundle";
        }

    @PostMapping
    public String updateBundle(@ModelAttribute("bundle") Bundle bundle) {
        bundleService.updateBundle(bundle);
        return "bundleupdated";
    }

    @GetMapping("/deleteBundle")
    public String deleteBundle(@RequestParam("id") Long id) {
        bundleService.deleteById(id);
        return "deletebundle";
    }

    @GetMapping("/addProducts")
    public String addProduct(@RequestParam("id") Long id, Model model,@Valid @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().add(product);
        model.addAttribute("bundle", bundle);
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("productsAdded", bundle.getProducts());
        return "managebundleproducts";
    }

    @GetMapping("/removeProducts")
    public String removeProduct(@RequestParam("id") Long id, Model model, @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().remove(product);
        model.addAttribute("bundle", bundle);
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("productsAdded", bundle.getProducts());
        return "managebundleproducts";
    }

    @GetMapping("/manageBundleProducts")
    public String manageBundleProducts(@RequestParam("id") Long id, Model model) {
        Bundle bundle = bundleService.getBundleById(id).get();
        System.out.println(bundle.getBundle_id());
        model.addAttribute("bundle", bundle);
        List<Product> products = productService.listProducts();
        products.removeIf(product -> bundle.getProducts().contains(product));
        model.addAttribute("products", products);
        model.addAttribute("productsAdded", bundle.getProducts());
        return "managebundleproducts";
    }
}
