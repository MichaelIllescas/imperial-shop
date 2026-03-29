package com.imperialnet.imperalshop.category.interfaces.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeStatusCategoryRequestDTO {
    @NotBlank(message = "El estado es obligatorio")
    private String status;

}
