package com.imperialnet.imperalshop.category.infrastructure.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.infrastructure.persistence.entity.CategoryEntity;

@Repository

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>    {

    Optional<Category> findBySlug(String slug);

    boolean existsBySlug(String slug);

    void existsByName(String name);

} 

