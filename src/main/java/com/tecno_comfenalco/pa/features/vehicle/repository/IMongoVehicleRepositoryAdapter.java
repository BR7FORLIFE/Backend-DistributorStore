package com.tecno_comfenalco.pa.features.vehicle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.vehicle.entity.mongo.VehicleDocument;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.features.vehicle.ports.IVehicleRepositoryPort;
import com.tecno_comfenalco.pa.features.vehicle.repository.mongo.IMongoVehicleRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("mongo")
@Repository
public class IMongoVehicleRepositoryAdapter implements IVehicleRepositoryPort {

    private final IMongoVehicleRepository repository;
    private final EntityMapper<VehicleModel, VehicleDocument> mapper;

    public IMongoVehicleRepositoryAdapter(IMongoVehicleRepository repository,
            EntityMapper<VehicleModel, VehicleDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VehicleModel save(VehicleModel vehicleEntity) {
        VehicleDocument entity = mapper.toEntity(vehicleEntity);
        VehicleDocument savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public Optional<VehicleModel> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<VehicleModel> findByVehiclePlate(String plate) {
        return repository.findByVehiclePlate(plate).map(mapper::toDto);
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
