package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "bundles")
@Data
@AllArgsConstructor
public class Bundle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bundle_id;

    private String name;

    private String description;

    private Double price;

    private int quantity;

    @ManyToMany(mappedBy = "bundles")
    private List<Product> products;

    public Bundle() {}
}
