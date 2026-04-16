package com.tecno_comfenalco.pa.features.distributor.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;
import com.tecno_comfenalco.pa.security.entity.mongo.UserDocument;
import com.tecno_comfenalco.pa.shared.dto.DirectionDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "user", "storesDistributors" })
@ToString(exclude = { "user", "storesDistributors" })
@Document(collection = "distributors")
public class DistributorDocument {

    @Id
    private String id;

    private Long NIT;

    private String name;
    private String phoneNumber;
    private String email;

    private DirectionDto direction;

    @DBRef
    private UserDocument user;

    @DBRef
    private List<StoresDistributorsDocument> storesDistributors;
}
