package com.tecno_comfenalco.pa.application.catalog.dto.response;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

public record GetCatalogResponseDto(
        UUID catalogId,
        UUID distributorId,
        String distributorName,
        List<CategoryResponseDto> categories) {
    public record CategoryResponseDto(
            String categoryId,
            String categoryName,
            List<ProductSummaryModel> products,
            int productCount) {
    }
}
