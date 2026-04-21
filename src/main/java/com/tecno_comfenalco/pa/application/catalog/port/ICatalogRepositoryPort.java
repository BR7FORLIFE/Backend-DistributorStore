package com.tecno_comfenalco.pa.application.catalog.port;

import java.util.UUID;

import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;

public interface ICatalogRepositoryPort {
    boolean existsByDistributorIdAndCode(UUID distributorId, String code);

    boolean existsCategoryNameInCatalog(UUID catalogId, String categoryName);

    CatalogModel save(CatalogModel catalogModel);

    void addCategoryToCatalog(UUID catalogId, CategoryModel categoryModel);

}
