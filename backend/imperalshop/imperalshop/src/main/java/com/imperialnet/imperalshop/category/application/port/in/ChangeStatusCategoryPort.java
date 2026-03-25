package com.imperialnet.imperalshop.category.application.port.in;

import com.imperialnet.imperalshop.category.domain.model.Category;

public interface ChangeStatusCategoryPort {
    Category changeStatus(Long id, String status);

}
