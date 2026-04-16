package com.tecno_comfenalco.pa.features.presales.entity.mongo;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "user", "distributor" })
@ToString(exclude = { "user", "distributor" })
@Document(collection = "presales")
public class PresalesDocument {

    @Id
    private String id;

    private String name;
    private String phoneNumber;
    private String email;

    private DocumentTypeEnum documentType;
    private Long documentNumber;

    @DBRef
    private UserDocument user;

    @DBRef
    private DistributorDocument distributor;
}
