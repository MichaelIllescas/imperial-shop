package com.imperialnet.imperalshop.category.infrastructure.persistence.adapter;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.imperialnet.imperalshop.category.application.port.out.CategoryPersistencePort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.infrastructure.persistence.entity.CategoryEntity;
import com.imperialnet.imperalshop.category.infrastructure.persistence.repository.CategoryRepository;
import com.imperialnet.imperalshop.category.interfaces.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
@Component
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        CategoryEntity saved = categoryRepository.save(categoryEntity);
        return categoryMapper.toDomain(saved);
}

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id)
        .map(categoryMapper::toDomain);
    }
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
        .map(categoryMapper::toDomain);
        
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }
}
