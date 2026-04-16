package com.tecno_comfenalco.pa.features.routes.deliveries.entity.mongo;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;
import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "delivery_routes")
public class DeliveryRoutesDocument {

    @Id
    private String id;

    @DBRef
    private OrderDocument orderEntity;

    @DBRef
    private DeliveryDocument delivery;
}
