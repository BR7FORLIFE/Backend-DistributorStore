package com.tecno_comfenalco.pa.features.order.entity.mongo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;
import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "orders")
@Data
@EqualsAndHashCode(exclude = { "store", "presales", "orderDetails" })
@ToString(exclude = { "store", "presales", "orderDetails" })
public class OrderDocument {

    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELLED
    }

    @Id
    private String id;

    private Double iva_percent;
    private Double total;

    private OrderStatus status;

    @DBRef
    private StoreDocument store;

    @DBRef
    private PresalesDocument presales;

    @DBRef
    private List<OrderDetailDocument> orderDetails;

    private Long distributorId;
}
