package com.tecno_comfenalco.pa.features.vehicle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.vehicle.entity.postgres.VehicleEntity;
import com.tecno_comfenalco.pa.features.vehicle.mapper.PostgresVehicleMapper;
import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;
import com.tecno_comfenalco.pa.features.vehicle.ports.IVehicleRepositoryPort;
import com.tecno_comfenalco.pa.features.vehicle.repository.postgres.IPostgresVehicleRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresVehicleRepositoryAdapter implements IVehicleRepositoryPort {

    private final IPostgresVehicleRepository repository;
    private final PostgresVehicleMapper mapper;

    public IPostgresVehicleRepositoryAdapter(IPostgresVehicleRepository repository,
            PostgresVehicleMapper mapper) {
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
    public Optional<VehicleModel> findById(String id) {
        Long parseId = SafeParser.safeParseId(id);

        if (parseId == null) {
            return Optional.empty();
        }

        Optional<VehicleEntity> entityOpt = repository.findById(parseId);
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
    public void deleteById(String id) {
        Long parseId = SafeParser.safeParseId(id);

        if (parseId == null) {
            return;
        }

        repository.deleteById(parseId);
    }

}
