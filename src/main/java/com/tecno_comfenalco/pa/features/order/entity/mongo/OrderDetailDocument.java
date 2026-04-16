package com.tecno_comfenalco.pa.features.order.entity.mongo;

import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "order_details")
public class OrderDetailDocument {

    @Id
    private String id;

    @DBRef
    private OrderDocument order;

    @DBRef
    private ProductDocument product;

    private Integer quantity;

    private Double unitPrice;
}
