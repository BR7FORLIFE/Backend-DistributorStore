package com.tecno_comfenalco.pa.features.routes.presales.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;
import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "presales_routes")
public class PresalesRoutesDocument {

    @Id
    private String id;

    @DBRef
    private List<StoreDocument> stores;

    @DBRef
    private PresalesDocument presalesRoute;
}
