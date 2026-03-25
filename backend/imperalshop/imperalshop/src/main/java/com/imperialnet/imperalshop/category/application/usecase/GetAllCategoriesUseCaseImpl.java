package com.imperialnet.imperalshop.category.application.usecase;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.imperialnet.imperalshop.category.application.port.in.GetAllCategoriesPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.domain.service.GetAllCategoriesService;

@Service
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesPort {

    private final GetAllCategoriesService getAllCategoriesService;

    public GetAllCategoriesUseCaseImpl(GetAllCategoriesService getAllCategoriesService) {
        this.getAllCategoriesService = getAllCategoriesService;
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return getAllCategoriesService.getAll(pageable);
    }
}
