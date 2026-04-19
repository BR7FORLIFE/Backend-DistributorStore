package com.tecno_comfenalco.pa.features.vehicle.models;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class VehicleModel {

    private String id;

    private String vehiclePlate;
    private String model;
    private String brand;

    private List<DeliveryModel> deliveries;

    private DistributorModel distributor;

    public VehicleModel(String id, String vehiclePlate, String model, String brand, List<DeliveryModel> deliveries,
            DistributorModel distributor) {
        this.id = id;
        this.vehiclePlate = vehiclePlate;
        this.model = model;
        this.brand = brand;
        this.deliveries = deliveries;
        this.distributor = distributor;
    }

    public static VehicleModel createDraft(
            String vehiclePlate,
            String model,
            String brand,
            List<DeliveryModel> deliveries,
            DistributorModel distributor) {

        return new VehicleModel(
                UUID.randomUUID().toString(),
                vehiclePlate,
                model,
                brand,
                deliveries,
                distributor);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<DeliveryModel> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliveryModel> deliveries) {
        this.deliveries = deliveries;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }

}
