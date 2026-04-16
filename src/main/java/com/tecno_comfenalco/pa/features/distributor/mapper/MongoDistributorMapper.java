package com.tecno_comfenalco.pa.features.distributor.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoDistributorMapper implements EntityMapper<DistributorModel, DistributorDocument> {

    @Override
    public DistributorModel toDto(DistributorDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public DistributorDocument toEntity(DistributorModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<DistributorModel> toDto(List<DistributorDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<DistributorDocument> toEntity(List<DistributorModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<DistributorModel> toDto(Set<DistributorDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<DistributorDocument> toEntity(Set<DistributorModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(DistributorModel dto, DistributorDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
