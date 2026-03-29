package com.imperialnet.imperalshop.category.application.usecase;

import com.imperialnet.imperalshop.category.application.port.in.UpdateCategoryPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.domain.service.UpdateCategoryService;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryUseCaseImpl implements UpdateCategoryPort {

    private final UpdateCategoryService updateCategoryService;

    public UpdateCategoryUseCaseImpl(UpdateCategoryService updateCategoryService) {
        this.updateCategoryService = updateCategoryService;
    }

    @Override
    public Category update(Long id, String name, String slug, Integer sortOrder) {
        return updateCategoryService.updateCategory(id, name, slug, sortOrder);
    }
}
