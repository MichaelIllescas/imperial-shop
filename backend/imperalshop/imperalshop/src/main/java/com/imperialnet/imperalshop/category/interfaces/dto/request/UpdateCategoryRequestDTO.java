package com.imperialnet.imperalshop.category.interfaces.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequestDTO {

 @Size(max=150, message="El nombre de la categoria no puede tener mas de 150 caracteres")
 private String name;

 private String slug;

 private Integer sortOrder;
}
