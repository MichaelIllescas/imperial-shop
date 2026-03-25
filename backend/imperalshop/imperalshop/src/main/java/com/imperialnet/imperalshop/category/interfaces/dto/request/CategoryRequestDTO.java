package com.imperialnet.imperalshop.category.interfaces.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "El nombre debe tener un maximo de 150 caracteres")
    private String name;

    @NotBlank(message = "El slug es obligatorio")
    private String slug;
}
