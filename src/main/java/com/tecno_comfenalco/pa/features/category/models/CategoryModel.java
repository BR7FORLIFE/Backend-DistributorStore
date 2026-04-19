package com.tecno_comfenalco.pa.features.category.models;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public class CategoryModel {
    private String id;
    private String name;

    private List<ProductModel> products;
    private CatalogModel catalog;

    public CategoryModel() {
    }

    public static CategoryModel createDratf(String name, List<ProductModel> products, CatalogModel catalogModel) {
        return new CategoryModel(UUID.randomUUID().toString(), name, products, catalogModel);
    }

    public CategoryModel(String id, String name, List<ProductModel> products, CatalogModel catalog) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.catalog = catalog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public CatalogModel getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogModel catalog) {
        this.catalog = catalog;
    }

}
