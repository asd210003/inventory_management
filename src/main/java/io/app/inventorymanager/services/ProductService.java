package io.app.inventorymanager.services;

import io.app.inventorymanager.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void saveProduct(Product product);

    public void deleteById(Long product_id);

    public void updateProduct(Product product);

    public Optional<Product> getProductById(Long product_id);

    public List<Product> listProducts();
}
