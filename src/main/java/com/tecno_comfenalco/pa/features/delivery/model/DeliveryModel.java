package com.tecno_comfenalco.pa.features.delivery.model;

import java.util.List;
import java.util.UUID;


import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.routes.models.delivery.DeliveryRoutesModel;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;

public class DeliveryModel {

    public enum LicenseTypeEnum {
        A1, A2, A3, A4, B1, B2, B3, C1, C2, C3, C4, D1, D2, D3, D4
    }

    private String id;

    private String name;

    private DocumentTypeEnum documentType;

    private Long documentNumber;
    private String phoneNumber;

    private String licenseNumber;
    private LicenseTypeEnum licenseType;

    private List<DeliveryRoutesModel> routes;

    private UserModel user;

    private DistributorModel distributor;

    public DeliveryModel() {
    }

    public DeliveryModel(String id, String name, DocumentTypeEnum documentType, Long documentNumber, String phoneNumber,
            String licenseNumber, LicenseTypeEnum licenseType, List<DeliveryRoutesModel> routes, UserModel user,
            DistributorModel distributor) {
        this.id = id;
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.licenseType = licenseType;
        this.routes = routes;
        this.user = user;
        this.distributor = distributor;
    }

    public static DeliveryModel createDraft(String name, DocumentTypeEnum documentTypeEnum, Long documentNumber,
            String phoneNumber, String licenseNumber, LicenseTypeEnum licenseType, List<DeliveryRoutesModel> routes,
            UserModel user, DistributorModel distributor) {
        return new DeliveryModel(UUID.randomUUID().toString(), name, documentTypeEnum, documentNumber, phoneNumber,
                licenseNumber, licenseType, routes, user, distributor);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LicenseTypeEnum getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseTypeEnum licenseType) {
        this.licenseType = licenseType;
    }

    public List<DeliveryRoutesModel> getRoutes() {
        return routes;
    }

    public void setRoutes(List<DeliveryRoutesModel> routes) {
        this.routes = routes;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }

}
