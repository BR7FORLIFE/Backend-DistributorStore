package com.tecno_comfenalco.pa.features.vehicle.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.vehicle.models.VehicleModel;

public interface IVehicleRepositoryPort {
    VehicleModel save(VehicleModel vehicleEntity);

    Optional<VehicleModel> findById(Long id);

    Optional<VehicleModel> findByVehiclePlate(String plate);

    List<VehicleModel> findAll();

    void deleteById(Long id);
}
