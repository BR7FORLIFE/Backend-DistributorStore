package com.tecno_comfenalco.pa.features.presales.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoPresalesMapper implements EntityMapper<PresalesModel, PresalesDocument> {

    @Override
    public PresalesModel toDto(PresalesDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public PresalesDocument toEntity(PresalesModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<PresalesModel> toDto(List<PresalesDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<PresalesDocument> toEntity(List<PresalesModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<PresalesModel> toDto(Set<PresalesDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<PresalesDocument> toEntity(Set<PresalesModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(PresalesModel dto, PresalesDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
