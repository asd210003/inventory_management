package io.app.inventorymanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Bundle name cannot be blank")
    private String name;

    @NotBlank(message = "Bundle description cannot be blank")
    private String description;

    @Min(value = 0, message = "Bundle price must be 0 or greater")
    @NotNull(message = "Bundle price cannot be empty")
    private Double price;

    @Min(value = 1, message = "Bundle quantity cannot less than 1")
    @NotNull(message = "Bundle quantity cannot be empty")
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
