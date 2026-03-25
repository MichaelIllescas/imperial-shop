package com.imperialnet.imperalshop.category.application.usecase;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.in.CreateCategoryPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.domain.service.CreateCategoryService;

@Service
public class CreateCategoryUseCaseImpl implements CreateCategoryPort {

    private final CreateCategoryService createCategoryService;

    public CreateCategoryUseCaseImpl(CreateCategoryService categoryService) {
        this.createCategoryService = categoryService;
    }

    @Override
    public Category create(String name, String slug) {
        return createCategoryService.createCategory(name, slug);
    }
}
