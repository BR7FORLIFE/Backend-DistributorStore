package com.tecno_comfenalco.pa.features.presales.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.presales.entity.postgres.PresalesEntity;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresPresalesMapper implements EntityMapper<PresalesModel, PresalesEntity> {

    @Override
    public PresalesModel toDto(PresalesEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public PresalesEntity toEntity(PresalesModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<PresalesModel> toDto(List<PresalesEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<PresalesEntity> toEntity(List<PresalesModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<PresalesModel> toDto(Set<PresalesEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<PresalesEntity> toEntity(Set<PresalesModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(PresalesModel dto, PresalesEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
