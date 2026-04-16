package com.tecno_comfenalco.pa.features.presales.models;

import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.security.model.UserModel;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;

public class PresalesModel {
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;

    private DocumentTypeEnum documentType;
    private Long documentNumber;

    private UserModel user;

    private DistributorModel distributor;

    public PresalesModel(Long id, String name, String phoneNumber, String email, DocumentTypeEnum documentType,
            Long documentNumber, UserModel user, DistributorModel distributor) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.user = user;
        this.distributor = distributor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
