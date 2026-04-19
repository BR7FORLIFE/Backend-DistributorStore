package com.tecno_comfenalco.pa.features.product.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;
import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDetailDocument;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "orderDetails", "categoryProduct", "distributor" })
@ToString(exclude = { "orderDetails", "categoryProduct", "distributor" })
@Document(collection = "products")
public class ProductDocument {

    public static enum Unit {
        UNIT, KILOGRAM, LITER, METER, PACK, BOX
    }

    @Id
    private String id;

    private String name;
    private Double price;

    private Unit unit;

    @DBRef
    private List<OrderDetailDocument> orderDetails;


    @DBRef
    private DistributorDocument distributor;
}
