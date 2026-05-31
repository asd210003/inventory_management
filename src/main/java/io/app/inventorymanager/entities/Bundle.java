package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

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

    @Min(value = 0, message = "Bundle price cannot be negative")
    private Double price;

    @Min(value = 0, message = "Bundle quantity cannot be negative")
    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "product_bundles",
            joinColumns = @JoinColumn(name = "bundle_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    public Bundle() {}
}
