package com.tecno_comfenalco.pa.features.vehicle.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;
import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "vehicles")
public class VehicleDocument {

    @Id
    private String id;

    private String vehiclePlate;
    private String model;
    private String brand;

    @DBRef
    private List<DeliveryDocument> deliveries;

    @DBRef
    private DistributorDocument distributor;
}
