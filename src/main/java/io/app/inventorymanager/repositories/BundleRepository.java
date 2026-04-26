package io.app.inventorymanager.repositories;

import io.app.inventorymanager.entities.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BundleRepository extends JpaRepository<Bundle, Long> {
}
