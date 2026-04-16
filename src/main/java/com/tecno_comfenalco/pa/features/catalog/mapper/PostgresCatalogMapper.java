package com.tecno_comfenalco.pa.features.catalog.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.CatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresCatalogMapper implements EntityMapper<CatalogModel, CatalogEntity> {

    @Override
    public CatalogModel toDto(CatalogEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public CatalogEntity toEntity(CatalogModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<CatalogModel> toDto(List<CatalogEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<CatalogEntity> toEntity(List<CatalogModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<CatalogModel> toDto(Set<CatalogEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<CatalogEntity> toEntity(Set<CatalogModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(CatalogModel dto, CatalogEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
