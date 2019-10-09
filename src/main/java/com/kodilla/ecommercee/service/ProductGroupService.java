package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductGroup;
import com.kodilla.ecommercee.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductGroupService {
    @Autowired
    private ProductGroupRepository productGroupRepository;

    public List<ProductGroup> findAllProductGroups() {
        return productGroupRepository.findAll();
    }

    public Optional<ProductGroup> findGroupById(final long groupId) {
        return productGroupRepository.findById(groupId);
    }

    public ProductGroup saveProductGroup(final ProductGroup productGroup) {
        return productGroupRepository.save(productGroup);
    }
}
