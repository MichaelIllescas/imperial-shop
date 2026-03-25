package com.imperialnet.imperalshop.category.interfaces.http;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imperialnet.imperalshop.category.application.port.in.ChangeStatusCategoryPort;
import com.imperialnet.imperalshop.category.application.port.in.CreateCategoryPort;
import com.imperialnet.imperalshop.category.application.port.in.DeleteCategoryPort;
import com.imperialnet.imperalshop.category.application.port.in.GetAllCategoriesPort;
import com.imperialnet.imperalshop.category.application.port.in.GetCategoryByIdPort;
import com.imperialnet.imperalshop.category.application.port.in.UpdateCategoryPort;
import com.imperialnet.imperalshop.category.domain.model.Category;
import com.imperialnet.imperalshop.category.interfaces.dto.request.CategoryRequestDTO;
import com.imperialnet.imperalshop.category.interfaces.dto.request.ChangeStatusCategoryRequestDTO;
import com.imperialnet.imperalshop.category.interfaces.dto.request.UpdateCategoryRequestDTO;
import com.imperialnet.imperalshop.category.interfaces.dto.response.CategoryResponseDTO;
import com.imperialnet.imperalshop.category.interfaces.mapper.CategoryMapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/categories")
@Tag(name = "Categories", description = "Operaciones para la gestión de categorías")
public class CategoryController {
    private final CreateCategoryPort createCategoryPort;  
    private final CategoryMapper categoryMapper;
    private final UpdateCategoryPort updateCategoryPort;
    private final ChangeStatusCategoryPort changeStatusCategoryPort;
    private final GetAllCategoriesPort getAllCategoriesPort;
    private final GetCategoryByIdPort getCategoryByIdPort;  
    private final DeleteCategoryPort deleteCategoryPort;
    
    public CategoryController(CreateCategoryPort createCategoryPort, UpdateCategoryPort updateCategoryPort, CategoryMapper categoryMapper, ChangeStatusCategoryPort changeStatusCategoryPort, GetAllCategoriesPort getAllCategoriesPort, GetCategoryByIdPort getCategoryByIdPort, DeleteCategoryPort deleteCategoryPort) {
        this.createCategoryPort = createCategoryPort;
        this.updateCategoryPort = updateCategoryPort;
        this.categoryMapper = categoryMapper;
        this.changeStatusCategoryPort = changeStatusCategoryPort;
        this.getAllCategoriesPort = getAllCategoriesPort;
        this.getCategoryByIdPort = getCategoryByIdPort;
        this.deleteCategoryPort = deleteCategoryPort;
    }

    @Operation(summary = "Crear categoría", description = "Crea una nueva categoría en el sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Categoría creada exitosamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Ya existe una categoría con ese slug", content = @Content)
    })

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO create(@Valid @RequestBody CategoryRequestDTO request) {
        Category category = createCategoryPort.create(request.getName(), request.getSlug());
        return categoryMapper.toResponse(category);

}

    @Operation(summary = "Actualizar categoría", description = "Actualiza el nombre, slug y orden de una categoría existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoría actualizada exitosamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })

@PutMapping("/{id}")
@ResponseStatus(HttpStatus.OK)

public CategoryResponseDTO update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequestDTO request) {
    Category category = updateCategoryPort.update(
        id,
        request.getName(),
        request.getSlug(),
        request.getSortOrder() != null ? request.getSortOrder() : -1

    );
    return categoryMapper.toResponse(category);

}

    @Operation(summary = "Cambiar estado de categoría", description = "Activa o desactiva una categoría según el estado enviado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estado actualizado exitosamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Estado inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })

@PatchMapping("/{id}/status")
@ResponseStatus(HttpStatus.OK)
public CategoryResponseDTO changeStatus(@PathVariable Long id, @Valid @RequestBody ChangeStatusCategoryRequestDTO request) {
    Category category = changeStatusCategoryPort.changeStatus(id, request.getStatus());
    return categoryMapper.toResponse(category);
}

    @Operation(summary = "Listar categorías", description = "Retorna un listado paginado de todas las categorías")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido exitosamente",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })

@GetMapping
@ResponseStatus(HttpStatus.OK)
public Page<CategoryResponseDTO> getAll(Pageable pageable) {
    return getAllCategoriesPort.getAll(pageable)
    .map(categoryMapper::toResponse);
}

    @Operation(summary = "Obtener categoría por ID", description = "Retorna los datos de una categoría específica por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoría encontrada",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })

@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public CategoryResponseDTO getById(@PathVariable Long id) {
    Category category = getCategoryByIdPort.getById(id);
    return categoryMapper.toResponse(category);
}

    @Operation(summary = "Eliminar categoría", description = "Elimina permanentemente una categoría por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Categoría eliminada exitosamente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id) {
    deleteCategoryPort.delete(id);
}

}