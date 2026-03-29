package com.imperialnet.imperalshop.category.domain.service;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.shared.exception.BadRequestException;
import com.imperialnet.imperalshop.shared.exception.NotFoundException;

@Service
public class ChangeStatusCategoryService {

    private final CategoryPersistencePort categoryPersistencePort;

    public ChangeStatusCategoryService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    public Category changeStatus(Long id, String status) {
        Category category = categoryPersistencePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));

        switch (status.toUpperCase()) {
            case "ACTIVE" -> category.activate();
            case "INACTIVE" -> category.deactivate();
            default -> throw new BadRequestException("Estado de categoria invalido: " + status);
        }
        return categoryPersistencePort.save(category);
    }
}