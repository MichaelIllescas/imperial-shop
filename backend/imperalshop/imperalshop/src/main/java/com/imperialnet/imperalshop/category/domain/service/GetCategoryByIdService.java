package com.imperialnet.imperalshop.category.domain.service;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.shared.exception.NotFoundException;

@Service
public class GetCategoryByIdService {

    private final CategoryPersistencePort categoryPersistencePort;

    public GetCategoryByIdService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    public Category getById(Long id) {
        return categoryPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
    }
}
