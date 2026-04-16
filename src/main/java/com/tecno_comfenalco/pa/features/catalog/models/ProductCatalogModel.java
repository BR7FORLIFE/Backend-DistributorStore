package com.tecno_comfenalco.pa.features.catalog.models;

import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public class ProductCatalogModel {
    private Long id;
    private CategoryModel category;
    private ProductModel product;

    public ProductCatalogModel() {
    }

    public ProductCatalogModel(Long id, CategoryModel categoryModel, ProductModel productModel) {
        this.id = id;
        this.category = categoryModel;
        this.product = productModel;
    }

    public Long getId() {
        return id;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
