package com.tecno_comfenalco.pa.application.catalog.command.actions;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

public record AddCategoryToCatalogCommand(UUID catalogId, String name, List<ProductSummaryModel> products) {

}
