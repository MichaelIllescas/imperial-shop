package com.imperialnet.imperalshop.category.application.usecase;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.in.ChangeStatusCategoryPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.domain.service.ChangeStatusCategoryService;

@Service
public class ChangeStatusCategoryUseCaseImpl implements ChangeStatusCategoryPort {
    private final ChangeStatusCategoryService changeStatusCategoryService;

    public ChangeStatusCategoryUseCaseImpl(ChangeStatusCategoryService changeStatusCategoryService) {
        this.changeStatusCategoryService = changeStatusCategoryService;
    }

    @Override
    public Category changeStatus(Long id, String status) {
        return changeStatusCategoryService.changeStatus(id, status);
    }

}
