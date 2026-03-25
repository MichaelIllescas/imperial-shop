package com.imperialnet.imperalshop.category.domain.service;

import org.springframework.stereotype.Service;

import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.shared.exception.NotFoundException;

@Service
public class UpdateCategoryService {
    private final CategoryPersistencePort categoryPersistencePort;  

    public UpdateCategoryService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }
    public Category updateCategory(Long id, String name, String slug, Integer sortOrder) {
        Category category = categoryPersistencePort.findById(id)
        .orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
     
        if (name !=null) category.rename(name);
        if (slug !=null) category.changeSlug(slug);
        if (sortOrder >=0) category.reorder(sortOrder);

        return categoryPersistencePort.save(category);

}
}