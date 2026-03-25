package com.imperialnet.imperalshop.category.application.port.in;

import com.imperialnet.imperalshop.category.domain.model.Category;

public interface UpdateCategoryPort {
Category update(Long id, String name, String slug, Integer sortOrder);
}
