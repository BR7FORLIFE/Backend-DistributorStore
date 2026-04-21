package com.tecno_comfenalco.pa.domain.product.model;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.enums.Unit;

public class ProductModel {
    private UUID id;
    private UUID distributorId;
    private String sku;
    private String name;
    private Unit unit;

    public ProductModel(UUID id, UUID distributorId, String sku, String name, Unit unit) {
        this.id = id;
        this.distributorId = distributorId;
        this.name = name;
        this.sku = sku;
        this.unit = unit;
    }

    public static ProductModel createNew(UUID id, UUID distributorId, String sku, String name, Unit unit) {
        return new ProductModel(id, distributorId, sku, name, unit);
    }

    public static ProductModel createDraft(UUID distributorId, String sku, String name, Unit unit) {
        return new ProductModel(UUID.randomUUID(), distributorId, sku, name, unit);
    }

    public UUID getDistributorId() {
        return distributorId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getSku() {
        return sku;
    }
}
