package com.tecno_comfenalco.pa.infrastructure.catalog.mapper;

import java.util.List;

import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.infrastructure.catalog.entity.CatalogDocument;
import com.tecno_comfenalco.pa.infrastructure.category.entity.CategoryEmbeddedEntity;
import com.tecno_comfenalco.pa.infrastructure.category.mapper.CategoryEmbeddedMapper;

public class CatalogMapper {
    public static CatalogModel toDomain(CatalogDocument catalogDocument) {
        if (catalogDocument == null) {
            return null;
        }

        List<CategoryModel> categoryModels = catalogDocument.getCategories()
                .stream()
                .map(CategoryEmbeddedMapper::toDomain)
                .toList();

        CatalogModel catalogModel = CatalogModel.createNew(catalogDocument.getId(), catalogDocument.getDistributorId(),
                catalogDocument.getCatalogCode(), catalogDocument.getName(), categoryModels);

        return catalogModel;
    }

    public static CatalogDocument toEntity(CatalogModel catalogModel) {
        List<CategoryEmbeddedEntity> categoryEmbeddedEntities = catalogModel.getCategories()
                .stream()
                .map(CategoryEmbeddedMapper::toEntity)
                .toList();

        CatalogDocument catalogDocument = new CatalogDocument(catalogModel.getId(), catalogModel.getDistributorId(),
                catalogModel.getCatalogCode(), catalogModel.getName(), categoryEmbeddedEntities);

        return catalogDocument;
    }
}
