package com.tecno_comfenalco.pa.domain.product.model;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.enums.Unit;

public class ProductSummaryModel {
    private UUID id;
    private String name;
    private Unit unit;
    private Double price;

    public ProductSummaryModel(UUID id, String name, Unit unit, Double price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public static ProductSummaryModel createNew(UUID id, String name, Unit unit, Double price) {
        return new ProductSummaryModel(id, name, unit, price);
    }

    public static ProductSummaryModel createDraft(String name, Unit unit, Double price) {
        return new ProductSummaryModel(UUID.randomUUID(), name, unit, price);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Unit getUnit() {
        return unit;
    }
}
