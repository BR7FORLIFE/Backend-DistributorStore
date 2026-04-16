package com.tecno_comfenalco.pa.features.catalog.ports;

import java.util.List;

import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;

public interface IProductsCatalogRepositoryPort {
    ProductCatalogModel save(ProductCatalogModel productCatalogModel);

    List<ProductCatalogModel> findAll();
}
