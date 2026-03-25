package com.imperialnet.imperalshop.category.application.usecase;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.in.DeleteCategoryPort;
import com.imperialnet.imperalshop.category.domain.service.DeleteCategoryService;

@Service
public class DeleteCategoryServiceUseCaseImpl implements DeleteCategoryPort {

    private final DeleteCategoryService deleteCategoryService;

    public DeleteCategoryServiceUseCaseImpl(DeleteCategoryService deleteCategoryService) {
        this.deleteCategoryService = deleteCategoryService;
    }
    @Override
    public void delete(Long id) {
        deleteCategoryService.delete(id);
    }
}
