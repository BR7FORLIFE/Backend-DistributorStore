package com.tecno_comfenalco.pa.infrastructure.delivery.mapper;

import java.util.List;

import com.tecno_comfenalco.pa.domain.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.infrastructure.delivery.entity.DeliveryDocument;
import com.tecno_comfenalco.pa.infrastructure.vehicle.entity.VehicleSummaryDocument;
import com.tecno_comfenalco.pa.infrastructure.vehicle.mapper.VehicleMapper;

public class DeliveryMapper {

    public static DeliveryModel toDomain(DeliveryDocument deliveryDocument) {

        List<VehicleSummaryModel> vehiclesModel = null;

        if (!deliveryDocument.getVehicles().isEmpty()) {
            vehiclesModel = deliveryDocument.getVehicles()
                    .stream()
                    .map(VehicleMapper::toSummaryModel)
                    .toList();
        }

        DeliveryModel delivery = DeliveryModel.createNew(deliveryDocument.getId(), deliveryDocument.getDistributorId(),
                deliveryDocument.getName(), deliveryDocument.getDocumentType(), deliveryDocument.getDocumentNumber(),
                deliveryDocument.getPhoneNumber(), deliveryDocument.getLicenseNumber(),
                deliveryDocument.getLicenseType(), vehiclesModel);

        return delivery;
    }

    public static DeliveryDocument toEntity(DeliveryModel deliveryModel) {

        List<VehicleSummaryDocument> vehicles = null;

        if (!deliveryModel.getVehicles().isEmpty()) {
            vehicles = deliveryModel.getVehicles()
                    .stream()
                    .map(VehicleMapper::toSummaryEntity)
                    .toList();
        }

        DeliveryDocument delivery = new DeliveryDocument();

        delivery.setId(deliveryModel.getId());
        delivery.setDistributorId(deliveryModel.getDistributorId());
        delivery.setName(deliveryModel.getName());
        delivery.setDocumentType(deliveryModel.getDocumentType());
        delivery.setDocumentNumber(deliveryModel.getDocumentNumber());
        delivery.setPhoneNumber(deliveryModel.getPhoneNumber());
        delivery.setLicenseNumber(deliveryModel.getLicenseNumber());
        delivery.setLicenseType(deliveryModel.getLicenseType());
        delivery.setVehicles(vehicles);

        return delivery;
    }
}
