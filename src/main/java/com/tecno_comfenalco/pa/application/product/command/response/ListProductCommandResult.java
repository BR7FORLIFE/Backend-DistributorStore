package com.tecno_comfenalco.pa.application.product.command.response;

import java.util.List;

import com.tecno_comfenalco.pa.domain.product.model.ProductModel;

public record ListProductCommandResult(List<ProductModel> products, String message) {

}
