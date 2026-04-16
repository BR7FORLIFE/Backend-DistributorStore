package com.tecno_comfenalco.pa.features.category.models;

import java.util.List;

import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public class CategoryModel {
    private Long id;
    private String name;

    private List<ProductModel> products;
    private CatalogModel catalog;

    public CategoryModel() {
    }

    public CategoryModel(Long id, String name, List<ProductModel> products, CatalogModel catalog) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.catalog = catalog;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
