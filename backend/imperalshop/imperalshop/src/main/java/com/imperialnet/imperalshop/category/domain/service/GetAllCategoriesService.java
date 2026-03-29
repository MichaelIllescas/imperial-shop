package com.imperialnet.imperalshop.category.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;

@Service
public class GetAllCategoriesService {
 
    private final CategoryPersistencePort categoryPersistencePort;

    public GetAllCategoriesService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    public Page<Category> getAll(Pageable pageable) {
        return categoryPersistencePort.findAll(pageable);
    }
}
