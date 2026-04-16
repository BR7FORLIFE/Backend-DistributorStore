package com.tecno_comfenalco.pa.features.category.entity.mongo;

import java.util.List;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;
import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "products", "catalog" })
@ToString(exclude = { "products", "catalog" })
@Document(collection = "categories")
public class CategoryDocument {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<ProductDocument> products;

    @DBRef
    private CatalogDocument catalog;
}
