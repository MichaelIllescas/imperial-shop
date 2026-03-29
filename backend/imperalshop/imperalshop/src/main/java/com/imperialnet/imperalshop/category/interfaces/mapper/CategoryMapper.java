    package com.imperialnet.imperalshop.category.interfaces.mapper;

    import org.springframework.stereotype.Component;

    import com.imperialnet.imperalshop.category.domain.model.Category;
    import com.imperialnet.imperalshop.category.domain.model.CategoryStatus;
    import com.imperialnet.imperalshop.category.infrastructure.persistence.entity.CategoryEntity;
import com.imperialnet.imperalshop.category.interfaces.dto.response.CategoryResponseDTO;

    @Component
    public class CategoryMapper {

        public CategoryEntity toEntity(Category category) {
            CategoryEntity entity = new CategoryEntity();
            entity.setId(category.getId());
            entity.setName(category.getName());
            entity.setSlug(category.getSlug());
            entity.setStatus(category.getStatus().name());
            entity.setSortOrder(category.getSortOrder());
            entity.setCreatedAt(category.getCreatedAt());
            entity.setUpdatedAt(category.getUpdatedAt());
            return entity;
        }

        public Category toDomain(CategoryEntity entity) {
            return new Category(
                    entity.getId(),
                    entity.getName(),
                    entity.getSlug(),
                    CategoryStatus.valueOf(entity.getStatus()),
                    entity.getSortOrder(),
                    entity.getCreatedAt(),
                    entity.getUpdatedAt());
        }
        public CategoryResponseDTO toResponse(Category category) {
            return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getSlug(),
                category.getStatus().name(),
                category.getSortOrder(),
                category.getCreatedAt(),
                category.getUpdatedAt());
        }
    }
