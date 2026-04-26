package io.app.inventorymanager.repositories;

import io.app.inventorymanager.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
