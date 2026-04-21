package com.tecno_comfenalco.pa.application.product.dto.response;

import java.util.List;

import com.tecno_comfenalco.pa.domain.product.model.ProductModel;

public record ListProductsResponseDto(List<ProductModel> products, String message) {

}
