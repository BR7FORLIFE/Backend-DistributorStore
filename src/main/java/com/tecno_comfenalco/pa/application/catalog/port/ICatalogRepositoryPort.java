package com.tecno_comfenalco.pa.application.catalog.port;

import java.util.UUID;

import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

public interface ICatalogRepositoryPort {
    boolean existsByDistributorIdAndCode(UUID distributorId, String code);

    boolean existsCategoryByDistributorIdAndName(UUID catalogId, String categoryName);

    boolean existsCategoryByCatalogIdAndCategoryId(UUID catalogId, UUID categoryId);

    boolean existsByIdAndCategoriesIdAndCategoriesProductsId(UUID catalogId, UUID categoryId, UUID productId);

    CatalogModel save(CatalogModel catalogModel);

    void addCategoryToCatalog(UUID catalogId, CategoryModel categoryModel);

    void addProductToCategory(UUID categoryId, ProductSummaryModel model);

    boolean existsCatalogById(UUID catalogId);
}
