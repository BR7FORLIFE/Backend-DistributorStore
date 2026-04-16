package com.tecno_comfenalco.pa.features.vehicle.dto.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.vehicle.entity.postgres.VehicleEntity;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresVehicleMapper implements EntityMapper<VehicleModel, VehicleEntity> {

    @Override
    public VehicleModel toDto(VehicleEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public VehicleEntity toEntity(VehicleModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<VehicleModel> toDto(List<VehicleEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<VehicleEntity> toEntity(List<VehicleModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<VehicleModel> toDto(Set<VehicleEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<VehicleEntity> toEntity(Set<VehicleModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(VehicleModel dto, VehicleEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
