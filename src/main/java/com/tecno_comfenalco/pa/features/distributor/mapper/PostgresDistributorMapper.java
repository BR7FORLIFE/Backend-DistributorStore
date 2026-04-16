package com.tecno_comfenalco.pa.features.distributor.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.distributor.entity.postgres.DistributorEntity;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresDistributorMapper implements EntityMapper<DistributorModel, DistributorEntity>{

    @Override
    public DistributorModel toDto(DistributorEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public DistributorEntity toEntity(DistributorModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<DistributorModel> toDto(List<DistributorEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<DistributorEntity> toEntity(List<DistributorModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<DistributorModel> toDto(Set<DistributorEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<DistributorEntity> toEntity(Set<DistributorModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(DistributorModel dto, DistributorEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
