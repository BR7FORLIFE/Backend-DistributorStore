package com.tecno_comfenalco.pa.features.catalog.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoCatalogMapper implements EntityMapper<CatalogModel, CatalogDocument> {

    @Override
    public CatalogModel toDto(CatalogDocument entity) {

        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public CatalogDocument toEntity(CatalogModel dto) {

        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<CatalogModel> toDto(List<CatalogDocument> entityList) {

        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<CatalogDocument> toEntity(List<CatalogModel> dtoList) {

        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<CatalogModel> toDto(Set<CatalogDocument> entitySet) {

        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<CatalogDocument> toEntity(Set<CatalogModel> dtoSet) {

        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(CatalogModel dto, CatalogDocument entity) {

        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

}
