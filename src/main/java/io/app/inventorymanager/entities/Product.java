package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotBlank(message = "Product description cannot be blank")
    private String description;

    @Min(value = 0, message = "Product price cannot be negative")
    private Double price;

    @Min(value = 1, message = "Product quantity cannot be negative")
    private Integer quantity;


    @ManyToMany(mappedBy = "products")
    private Set<Bundle> bundles = new HashSet<>();
    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return product_id != null &&
                product_id.equals(product.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id);
    }
}
