package io.app.inventorymanager.services;

import io.app.inventorymanager.entities.Bundle;

import java.util.List;
import java.util.Optional;

public interface BundleService {

    public void saveBundle(Bundle bundle);

    public void deleteById(Long bundle_id);

    public void updateBundle(Bundle bundle);

    public Optional<Bundle> getBundleById(Long bundle_id);

    public List<Bundle> listBundles();

    public List<Bundle> searchBundles(String searchTerm);
}
