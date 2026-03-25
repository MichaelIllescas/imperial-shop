package com.imperialnet.imperalshop.category.domain.service;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.shared.exception.NotFoundException;

@Service
public class DeleteCategoryService {

    private final CategoryPersistencePort categoryPersistencePort;

    public DeleteCategoryService(CategoryPersistencePort categoryPersistencePort) { 
        this.categoryPersistencePort = categoryPersistencePort;
    }

    public void delete(Long id) {
        if (!categoryPersistencePort.existsById(id)) {
            throw new NotFoundException("Categoria no encontrada con id: " + id);
    }
    categoryPersistencePort.delete(id);
}
}