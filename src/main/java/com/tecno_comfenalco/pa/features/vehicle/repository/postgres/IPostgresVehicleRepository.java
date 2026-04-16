package com.tecno_comfenalco.pa.features.vehicle.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.vehicle.entity.postgres.VehicleEntity;

public interface IPostgresVehicleRepository extends JpaRepository<VehicleEntity, Long> {
    VehicleEntity save(VehicleEntity vehicleEntity);

    Optional<VehicleEntity> findById(Long id);

    Optional<VehicleEntity> findByVehiclePlate(String plate);

    List<VehicleEntity> findAll();

    void deleteById(Long id);
}
