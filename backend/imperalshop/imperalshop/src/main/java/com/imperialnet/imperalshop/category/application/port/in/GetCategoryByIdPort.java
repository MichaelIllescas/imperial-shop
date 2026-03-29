package com.imperialnet.imperalshop.category.application.port.in;

import com.imperialnet.imperalshop.category.domain.model.Category;

public interface GetCategoryByIdPort {
    Category getById(Long id);

}
