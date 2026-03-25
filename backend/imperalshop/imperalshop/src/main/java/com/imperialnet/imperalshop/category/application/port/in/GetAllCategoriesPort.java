package com.imperialnet.imperalshop.category.application.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.imperialnet.imperalshop.category.domain.model.Category;

public interface GetAllCategoriesPort {
 Page<Category> getAll(Pageable pageable); 
}
