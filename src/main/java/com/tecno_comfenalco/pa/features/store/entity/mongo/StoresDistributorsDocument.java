package com.tecno_comfenalco.pa.features.store.entity.mongo;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "stores_distributors")
@Data
public class StoresDistributorsDocument {

    @Id
    private String id;

    @DBRef
    private StoreDocument store;

    @DBRef
    private DistributorDocument distributor;

    private String internalClientCode;
}
