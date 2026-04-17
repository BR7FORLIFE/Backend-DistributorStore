package com.tecno_comfenalco.pa.features.vehicle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.vehicle.entity.postgres.VehicleEntity;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.features.vehicle.ports.IVehicleRepositoryPort;
import com.tecno_comfenalco.pa.features.vehicle.repository.postgres.IPostgresVehicleRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("postgres")
@Repository
public class IPostgresVehicleRepositoryAdapter implements IVehicleRepositoryPort {

    private final IPostgresVehicleRepository repository;
    private final EntityMapper<VehicleModel, VehicleEntity> mapper;

    public IPostgresVehicleRepositoryAdapter(IPostgresVehicleRepository repository,
            EntityMapper<VehicleModel, VehicleEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VehicleModel save(VehicleModel vehicleEntity) {
        VehicleEntity entity = mapper.toEntity(vehicleEntity);
        VehicleEntity savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public Optional<VehicleModel> findById(Long id) {
        Optional<VehicleEntity> entityOpt = repository.findById(id);
        return entityOpt.map(mapper::toDto);
    }

    @Override
    public Optional<VehicleModel> findByVehiclePlate(String plate) {
        Optional<VehicleEntity> entityOpt = repository.findByVehiclePlate(plate);
        return entityOpt.map(mapper::toDto);
    }

    @Override
    public List<VehicleModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
