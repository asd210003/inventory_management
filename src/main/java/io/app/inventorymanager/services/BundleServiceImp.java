package io.app.inventorymanager.services;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.repositories.BundleRepository;

import java.util.List;
import java.util.Optional;

public class BundleServiceImp implements BundleService{

    private final BundleRepository bundleRepository;

    public BundleServiceImp(BundleRepository bundleRepository) {
        this.bundleRepository = bundleRepository;
    }


    @Override
    public void saveBundle(Bundle bundle) {
        bundleRepository.save(bundle);
    }

    @Override
    public void deleteById(Long bundle_id) {
        bundleRepository.deleteById(bundle_id);
    }

    @Override
    public void updateBundle(Bundle bundle) {
        bundleRepository.save(bundle);
    }

    @Override
    public Optional<Bundle> getBundleById(Long bundle_id) {
        return bundleRepository.findById(bundle_id);
    }

    @Override
    public List<Bundle> listBundles() {
        return bundleRepository.findAll();
    }
}
