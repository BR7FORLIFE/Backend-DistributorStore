package com.tecno_comfenalco.pa.infrastructure.category.mapper;

import java.util.List;

import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;
import com.tecno_comfenalco.pa.infrastructure.category.entity.CategoryEmbeddedEntity;
import com.tecno_comfenalco.pa.infrastructure.product.entity.ProductSummaryEmbeddedEntity;
import com.tecno_comfenalco.pa.infrastructure.product.mapper.ProductSummaryMapper;

public class CategoryEmbeddedMapper {
    public static CategoryModel toDomain(CategoryEmbeddedEntity categoryEmbeddedEntity) {
        if (categoryEmbeddedEntity == null) {
            return null;
        }

        List<ProductSummaryModel> productSummaryEmbeddedEntities = categoryEmbeddedEntity.getProducts()
                .stream()
                .map(ProductSummaryMapper::toDomain)
                .toList();

        CategoryModel categoryModel = CategoryModel.createNew(categoryEmbeddedEntity.getId(),
                categoryEmbeddedEntity.getName(), productSummaryEmbeddedEntities);
        return categoryModel;
    }

    public static CategoryEmbeddedEntity toEntity(CategoryModel categoryModel) {
        List<ProductSummaryEmbeddedEntity> productSummaryModels = categoryModel.getProducts().stream()
                .map(ProductSummaryMapper::toEntity)
                .toList();

        CategoryEmbeddedEntity categoryEmbeddedEntity = new CategoryEmbeddedEntity(categoryModel.getId(),
                categoryModel.getName(), productSummaryModels);

        return categoryEmbeddedEntity;
    }
}
