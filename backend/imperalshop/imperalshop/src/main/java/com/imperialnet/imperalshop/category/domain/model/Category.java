package com.imperialnet.imperalshop.category.domain.model;

import java.time.LocalDateTime;

import com.imperialnet.imperalshop.shared.exception.BadRequestException;
import com.imperialnet.imperalshop.shared.exception.ConflictException;

public class Category {
    private Long id;
    private String name;
    private String slug;
    private CategoryStatus status;
    private int sortOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Category(){
    }

    

    public Category(Long id, String name, String slug, CategoryStatus status, int sortOrder, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.status = status;
        this.sortOrder = sortOrder;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public static Category create(String name, String slug) {
        if (name == null || name.isBlank()) {
            throw new BadRequestException("El nombre de la categoria es obligatorio");
        }
        if (slug == null || slug.isBlank()) {
            throw new BadRequestException("El slug de la categoria es obligatorio");
        }
        Category category = new Category();
        category.name = name.trim();
        category.slug = slug.trim();
        category.status = CategoryStatus.ACTIVE;
        category.sortOrder = 0;
        category.createdAt = LocalDateTime.now();
        category.updatedAt = LocalDateTime.now();
        return category;
    }

    public boolean isActive() {
        return status == CategoryStatus.ACTIVE;
    }

    public void activate() {
        if (this.status == CategoryStatus.ACTIVE) {
        throw new ConflictException("La categoria ya esta activa");
    }
    this.status = CategoryStatus.ACTIVE;
    touch();
}
    public void deactivate() {
       if (this.status == CategoryStatus.INACTIVE) {
        throw new ConflictException("La categoria ya esta inactiva");
    }
    this.status = CategoryStatus.INACTIVE;
    touch();
}

public void rename (String newName) {
    if (newName == null || newName.isBlank()) {
        throw new BadRequestException("Nombre de la categoria invalido");
    }
    if (newName.length() > 150) {
        throw new BadRequestException("Maximo 150 caracteres");
}
    this.name = newName.trim();
    touch();
}

public void changeSlug (String newSlug) {
    if (newSlug == null || newSlug.isBlank()) {
        throw new BadRequestException("Slug de la categoria invalido");
    }
    this.slug = newSlug.trim();
    touch();
}

public void reorder (int newOrder) {
    if (newOrder < 0) {
        throw new BadRequestException("Orden invalido");
    }
    this.sortOrder = newOrder;
    touch();
}

private void touch() {
    this.updatedAt = LocalDateTime.now();
}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    
}
