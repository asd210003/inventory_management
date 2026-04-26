package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;


    @ManyToMany
    @JoinTable(name = "product_bundles",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "bundle_id")
    )
    private Set<Bundle> bundles = new HashSet<>();

    public Product() {
    }
}
