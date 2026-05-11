package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bundles")
@Getter
@Setter
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
    private Set<Product> products = new HashSet<>();

    public Bundle() {}
}
