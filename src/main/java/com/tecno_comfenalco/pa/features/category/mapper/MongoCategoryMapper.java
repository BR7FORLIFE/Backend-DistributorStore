package com.tecno_comfenalco.pa.features.category.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoCategoryMapper implements EntityMapper<CategoryModel, CategoryDocument> {

    @Override
    public CategoryModel toDto(CategoryDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public CategoryDocument toEntity(CategoryModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<CategoryModel> toDto(List<CategoryDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<CategoryDocument> toEntity(List<CategoryModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<CategoryModel> toDto(Set<CategoryDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<CategoryDocument> toEntity(Set<CategoryModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(CategoryModel dto, CategoryDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
