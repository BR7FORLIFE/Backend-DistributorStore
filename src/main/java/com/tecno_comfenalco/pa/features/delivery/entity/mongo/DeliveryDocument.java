package com.tecno_comfenalco.pa.features.delivery.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.routes.deliveries.entity.mongo.DeliveryRoutesDocument;
import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "deliveries")
public class DeliveryDocument {

    public enum LicenseTypeEnum {
        A1, A2, A3, A4, B1, B2, B3, C1, C2, C3, C4, D1, D2, D3, D4
    }

    @Id
    private String id;

    private String name;

    private DocumentTypeEnum documentType;

    private Long documentNumber;
    private String phoneNumber;

    private String licenseNumber;
    private LicenseTypeEnum licenseType;

    @DBRef
    private List<DeliveryRoutesDocument> routes;

    @DBRef
    private UserDocument user;

    @DBRef
    private DistributorDocument distributor;
}
