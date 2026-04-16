package com.tecno_comfenalco.pa.features.store.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoStoreMapper implements EntityMapper<StoreModel, StoreDocument> {

    @Override
    public StoreModel toDto(StoreDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public StoreDocument toEntity(StoreModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<StoreModel> toDto(List<StoreDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<StoreDocument> toEntity(List<StoreModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<StoreModel> toDto(Set<StoreDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<StoreDocument> toEntity(Set<StoreModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(StoreModel dto, StoreDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

}
