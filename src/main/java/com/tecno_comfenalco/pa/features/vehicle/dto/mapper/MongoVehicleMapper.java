package com.tecno_comfenalco.pa.features.vehicle.dto.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.vehicle.entity.mongo.VehicleDocument;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoVehicleMapper implements EntityMapper<VehicleModel, VehicleDocument> {

    @Override
    public VehicleModel toDto(VehicleDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public VehicleDocument toEntity(VehicleModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<VehicleModel> toDto(List<VehicleDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<VehicleDocument> toEntity(List<VehicleModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<VehicleModel> toDto(Set<VehicleDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<VehicleDocument> toEntity(Set<VehicleModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(VehicleModel dto, VehicleDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
