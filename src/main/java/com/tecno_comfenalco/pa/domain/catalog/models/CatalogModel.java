package com.tecno_comfenalco.pa.domain.catalog.models;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;

public class CatalogModel {
    private UUID id;
    private UUID distributorId;
    private String name;
    private List<CategoryModel> categories;

    public CatalogModel(UUID id, UUID distributorId, String name, List<CategoryModel> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public static CatalogModel createDraft(UUID distributorId, String name, List<CategoryModel> categories) {
        return new CatalogModel(UUID.randomUUID(), distributorId, name, categories);
    }

    public static CatalogModel createNew(UUID id, UUID distributorId, String name, List<CategoryModel> categories) {
        return new CatalogModel(id, distributorId, name, categories);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public UUID getDistributorId() {
        return distributorId;
    }
}
