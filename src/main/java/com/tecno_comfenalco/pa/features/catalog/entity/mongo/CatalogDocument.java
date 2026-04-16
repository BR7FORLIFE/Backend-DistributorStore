package com.tecno_comfenalco.pa.features.catalog.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode(exclude = { "distributor" })
@ToString(exclude = { "distributor" })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "catalogs")

public class CatalogDocument {
    @Id
    private String id;

    @DBRef
    private DistributorDocument distributor;
}
