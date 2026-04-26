package com.tecno_comfenalco.pa.domain.delivery.model;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.vehicle.model.VehicleSummaryModel;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;
import com.tecno_comfenalco.pa.shared.enums.LicenseTypeEnum;

public class DeliveryModel {
    private UUID id;
    private UUID distributorId;
    private String name;
    private DocumentTypeEnum documentType;
    private Long documentNumber;
    private Long phoneNumber;
    private Long licenseNumber;
    private LicenseTypeEnum licenseType;
    private List<VehicleSummaryModel> vehicles;

    public static DeliveryModel createDraft(UUID distributorId, String name, DocumentTypeEnum documentTypeEnum,
            Long documentNumber, Long phoneNumber, Long licenseNumber, LicenseTypeEnum licenseTypeEnum,
            List<VehicleSummaryModel> vehicles) {
        return new DeliveryModel(UUID.randomUUID(), distributorId, name, documentTypeEnum, documentNumber, phoneNumber,
                licenseNumber, licenseTypeEnum, vehicles);
    }

    public static DeliveryModel createNew(UUID id, UUID distributorId, String name, DocumentTypeEnum documentTypeEnum,
            Long documentNumber, Long phoneNumber, Long licenseNumber, LicenseTypeEnum licenseTypeEnum,
            List<VehicleSummaryModel> vehicles) {
        return new DeliveryModel(id, distributorId, name, documentTypeEnum, documentNumber, phoneNumber, licenseNumber,
                licenseTypeEnum, vehicles);
    }

    public DeliveryModel(UUID id, UUID distributorId, String name, DocumentTypeEnum documentType, Long documentNumber,
            Long phoneNumber, Long licenseNumber, LicenseTypeEnum licenseType, List<VehicleSummaryModel> vehicles) {
        this.id = id;
        this.distributorId = distributorId;
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.licenseType = licenseType;
        this.vehicles = vehicles;
    }

    public UUID getId() {
        return id;
    }

    public UUID getDistributorId() {
        return distributorId;
    }

    public String getName() {
        return name;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public LicenseTypeEnum getLicenseType() {
        return licenseType;
    }

    public List<VehicleSummaryModel> getVehicles() {
        return vehicles;
    }

}
