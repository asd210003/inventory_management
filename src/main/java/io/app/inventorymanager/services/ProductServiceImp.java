package io.app.inventorymanager.services;

import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long product_id) {
        productRepository.deleteById(product_id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long product_id) {
        return productRepository.findById(product_id);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String searchTerm) {
        return productRepository.filterBySearch(searchTerm);
    }
}
