package com.tecno_comfenalco.pa.infrastructure.catalog.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.catalog.command.actions.AddCategoryToCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.AddProductToCategoryCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.CreateCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddCategoryToCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddProductToCategoryCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.CreateCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.dto.request.AddCategoryToCatalogRequestDto;
import com.tecno_comfenalco.pa.application.catalog.dto.request.AddExistingProductToCategoryRequestDto;
import com.tecno_comfenalco.pa.application.catalog.dto.request.CreateCatalogRequestDto;
import com.tecno_comfenalco.pa.application.catalog.dto.response.AddCategoryToCatalogResponseDto;
import com.tecno_comfenalco.pa.application.catalog.dto.response.AddProductToCategoryResponseDto;
import com.tecno_comfenalco.pa.application.catalog.dto.response.CreateCatalogResponseDto;
import com.tecno_comfenalco.pa.application.catalog.dto.response.GetCatalogResponseDto;
import com.tecno_comfenalco.pa.application.catalog.dto.response.GetCategoryProductsResponseDto;
import com.tecno_comfenalco.pa.application.catalog.usecase.CatalogUseCase;
import com.tecno_comfenalco.pa.infrastructure.security.CustomUserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final CatalogUseCase catalogUseCase;

    public CatalogController(CatalogUseCase catalogUseCase) {
        this.catalogUseCase = catalogUseCase;
    }

    /**
     * Agrega una categoría al catálogo de la distribuidora autenticada
     * Solo DISTRIBUTOR puede ejecutar este método
     * El catálogo se detecta automáticamente según el usuario logueado
     */

    @PreAuthorize("hasRole('DISTRIBUTOR')")
    @PostMapping
    public ResponseEntity<CreateCatalogResponseDto> createCatalog(@RequestBody CreateCatalogRequestDto dto,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        CreateCatalogCommand cmd = new CreateCatalogCommand(details.getUserId(), dto.name(), dto.catalogCode());
        CreateCatalogCommandResult result = catalogUseCase.createCatalog(cmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateCatalogResponseDto(result.catalog(), result.message()));
    }

    @PostMapping("/{catalogId}/categories")
    @PreAuthorize("hasRole('DISTRIBUTOR')")
    public ResponseEntity<AddCategoryToCatalogResponseDto> addCategoryToCatalog(
            @PathVariable UUID catalogId,
            @RequestBody @Valid AddCategoryToCatalogRequestDto request,
            Authentication authentication) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        AddCategoryToCatalogCommand cmd = new AddCategoryToCatalogCommand(details.getUserId(), catalogId,
                request.name());

        AddCategoryToCatalogCommandResult result = catalogUseCase.addCategoryToCatalog(cmd);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new AddCategoryToCatalogResponseDto(result.catalogId(), result.categoryId(), result.message()));
    }

    /**
     * Agrega un producto existente a una categoría
     * Solo DISTRIBUTOR puede ejecutar este método
     * Valida automáticamente que la categoría pertenezca al catálogo del usuario
     * autenticado
     */
    @PostMapping("/{catalogId}/categories/{categoryId}/products")
    @PreAuthorize("hasRole('DISTRIBUTOR')")
    public ResponseEntity<AddProductToCategoryResponseDto> addProductToCategory(
            @PathVariable UUID catalogId,
            @PathVariable UUID categoryId,
            Authentication authentication,
            @RequestBody @Valid AddExistingProductToCategoryRequestDto request) {
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();

        AddProductToCategoryCommand cmd = new AddProductToCategoryCommand(details.getUserId(), catalogId, categoryId,
                request.productId());
        AddProductToCategoryCommandResult result = catalogUseCase.addProductToCategory(cmd);

        return ResponseEntity.ok().body(new AddProductToCategoryResponseDto(result.message()));
    }

    /**
     * Obtiene el catálogo completo de la distribuidora del usuario autenticado
     * Tanto DISTRIBUTOR como PRESALES pueden ver el catálogo de su distribuidora
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('DISTRIBUTOR', 'PRESALES')")
    public ResponseEntity<GetCatalogResponseDto> getMyCatalog() {
        return null;
    }

    /**
     * Obtiene todos los productos de una categoría específica
     * Tanto DISTRIBUTOR como PRESALES pueden ver, pero solo de su propia
     * distribuidora
     */
    @GetMapping("/{categoryId}/products")
    @PreAuthorize("hasAnyRole('DISTRIBUTOR', 'PRESALES')")
    public ResponseEntity<GetCategoryProductsResponseDto> getProductsByCategory(@PathVariable UUID categoryId) {
        return null;
    }
}
