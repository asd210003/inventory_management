package io.app.inventorymanager.data;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductService productService;
    private final BundleService bundleService;

    public BootstrapData(ProductService productService, BundleService bundleService) {
        this.productService = productService;
        this.bundleService = bundleService;
    }

    public void run(String... args) {
        Product product = new Product();
        product.setName("IPhone 15");
        product.setDescription("New technology product");
        product.setPrice(1050.00);
        product.setQuantity(3);
        productService.saveProduct(product);

        Product product2 = new Product();
        product2.setName("Samsung Galaxy S24");
        product2.setDescription("New technology product");
        product2.setPrice(1200.00);
        product2.setQuantity(2);
        productService.saveProduct(product2);

        Product product3 = new Product();
        product3.setName("Samsung Galaxy S24 Ultra");
        product3.setDescription("New technology product");
        product3.setPrice(1500.00);
        product3.setQuantity(1);
        productService.saveProduct(product3);

        Product product4 = new Product();
        product4.setName("Samsung Galaxy S24 Ultra");
        product4.setDescription("New technology product");
        product4.setPrice(1500.00);
        product4.setQuantity(1);
        productService.saveProduct(product4);

        Product product5 = new Product();
        product5.setName("Samsung Galaxy S24 Ultra");
        product5.setDescription("New technology product");
        product5.setPrice(1500.00);
        product5.setQuantity(1);
        productService.saveProduct(product5);

        Product product6 = new Product();
        product6.setName("Samsung Galaxy S24 Ultra");
        product6.setDescription("New technology product");
        product6.setPrice(1500.00);
        product6.setQuantity(1);
        productService.saveProduct(product6);

        Product product7 = new Product();
        product7.setName("Samsung Galaxy S24 Ultra");
        product7.setDescription("New technology product");
        product7.setPrice(1500.00);
        product7.setQuantity(1);
        productService.saveProduct(product7);

        Bundle bundle = new Bundle();
        bundle.setName("Item");
        bundle.setDescription("Description");
        bundle.setPrice(100.00);
        bundle.setQuantity(1);
        bundle.getProducts().add(product);
        bundle.getProducts().add(product2);
        bundleService.saveBundle(bundle);
    }
}
