package com.imperialnet.imperalshop.category.application.port.out;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.imperialnet.imperalshop.category.domain.model.Category;

public interface CategoryPersistencePort {
 Category save(Category category);
 Optional<Category> findById(Long id);
 void delete(Long id);
 boolean existsById(Long id);
 Page<Category> findAll(Pageable pageable);
}
