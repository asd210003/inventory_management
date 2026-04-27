package io.app.inventorymanager;

import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagerApplication.class, args);
    }
}
