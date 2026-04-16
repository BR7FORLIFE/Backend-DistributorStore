package com.tecno_comfenalco.pa.features.vehicle.repository.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tecno_comfenalco.pa.features.vehicle.entity.mongo.VehicleDocument;

public interface IMongoVehicleRepository extends MongoRepository<VehicleDocument, String> {
    VehicleDocument save(VehicleDocument vehicleEntity);

    Optional<VehicleDocument> findById(Long id);

    Optional<VehicleDocument> findByVehiclePlate(String plate);

    List<VehicleDocument> findAll();

    void deleteById(Long id);
}
