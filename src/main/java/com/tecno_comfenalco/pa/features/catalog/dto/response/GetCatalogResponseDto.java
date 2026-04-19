package com.tecno_comfenalco.pa.features.catalog.dto.response;

import java.util.List;

import com.tecno_comfenalco.pa.features.product.dto.ProductDto;

public record GetCatalogResponseDto(
                String catalogId,
                String distributorId,
                String distributorName,
                List<CategoryDto> categories) {
        public record CategoryDto(
                        String categoryId,
                        String categoryName,
                        List<ProductDto> products,
                        int productCount) {
        }
}
