package com.imperialnet.imperalshop.category.application.usecase;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.in.GetCategoryByIdPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.domain.service.GetCategoryByIdService;

@Service
public class GetCategoryByIdUseCaseImpl implements GetCategoryByIdPort {

    private final GetCategoryByIdService getCategoryByIdService;    

    public GetCategoryByIdUseCaseImpl(GetCategoryByIdService getCategoryGetByIdService) {
        this.getCategoryByIdService = getCategoryGetByIdService;
    }
    
    @Override
    public Category getById(Long id) {
        return getCategoryByIdService.getById(id);
    }

}
