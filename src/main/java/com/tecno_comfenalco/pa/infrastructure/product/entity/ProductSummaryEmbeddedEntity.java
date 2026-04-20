package com.tecno_comfenalco.pa.infrastructure.product.entity;

import java.util.UUID;

import com.tecno_comfenalco.pa.shared.enums.Unit;

public class ProductSummaryEmbeddedEntity {
    private UUID id;
    private String name;
    private Unit unit;
    private Double price;

    public ProductSummaryEmbeddedEntity(UUID id, String name, Unit unit, Double price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
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
