package io.app.inventorymanager.data;

import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductService productService;

    public BootstrapData(ProductService productService) {
        this.productService = productService;
    }

    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("IPhone 15");
        product.setDescription("New technology product");
        product.setPrice(1050.00);
        product.setQuantity(3);
        productService.saveProduct(product);
    }
}
