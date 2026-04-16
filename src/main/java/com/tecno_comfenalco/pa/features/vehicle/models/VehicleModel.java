package com.tecno_comfenalco.pa.features.vehicle.models;

import java.util.List;

import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;

public class VehicleModel {

    private Long id;

    private String vehiclePlate;
    private String model;
    private String brand;

    private List<DeliveryModel> deliveries;

    private DistributorModel distributor;

    public VehicleModel(Long id, String vehiclePlate, String model, String brand, List<DeliveryModel> deliveries,
            DistributorModel distributor) {
        this.id = id;
        this.vehiclePlate = vehiclePlate;
        this.model = model;
        this.brand = brand;
        this.deliveries = deliveries;
        this.distributor = distributor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
