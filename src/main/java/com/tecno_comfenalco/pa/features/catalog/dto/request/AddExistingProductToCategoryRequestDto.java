package com.tecno_comfenalco.pa.features.catalog.dto.request;


import jakarta.validation.constraints.NotNull;

public record AddExistingProductToCategoryRequestDto(
                @NotNull(message = "Product ID is required") String productId) {
}
