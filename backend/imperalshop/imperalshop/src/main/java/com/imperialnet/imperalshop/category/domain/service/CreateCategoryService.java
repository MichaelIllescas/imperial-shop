package com.imperialnet.imperalshop.category.domain.service;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;

@Service

public class CreateCategoryService {

    private final CategoryPersistencePort categoryPersistencePort;

    public CreateCategoryService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    public Category createCategory(String name, String slug) {
        Category category = Category.create(name, slug);
        return categoryPersistencePort.save(category);

    }
}

