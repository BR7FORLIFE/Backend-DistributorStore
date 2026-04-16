package com.tecno_comfenalco.pa.features.category.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.category.entity.postgres.CategoryEntity;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresCategoryMapper implements EntityMapper<CategoryModel, CategoryEntity> {

    @Override
    public CategoryModel toDto(CategoryEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public CategoryEntity toEntity(CategoryModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<CategoryModel> toDto(List<CategoryEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<CategoryEntity> toEntity(List<CategoryModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<CategoryModel> toDto(Set<CategoryEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<CategoryEntity> toEntity(Set<CategoryModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(CategoryModel dto, CategoryEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
