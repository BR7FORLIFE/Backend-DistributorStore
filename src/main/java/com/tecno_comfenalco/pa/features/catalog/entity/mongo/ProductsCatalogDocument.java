package com.tecno_comfenalco.pa.features.catalog.entity.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;
import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "category", "product" })
@ToString(exclude = { "category", "product" })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "categories_products")
public class ProductsCatalogDocument {
    @Id
    private String id;

    @DBRef
    private CategoryDocument category;

    @DBRef
    private ProductDocument product;
}
