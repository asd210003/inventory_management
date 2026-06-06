package io.app.inventorymanager.repositories;

import io.app.inventorymanager.entities.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BundleRepository extends JpaRepository<Bundle, Long> {

    @Query("SELECT b FROM Bundle b WHERE b.name LIKE %:search%")
    List<Bundle> searchByName(String search);
}
