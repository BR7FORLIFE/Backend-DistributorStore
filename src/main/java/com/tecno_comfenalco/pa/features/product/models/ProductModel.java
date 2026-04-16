package com.tecno_comfenalco.pa.features.product.models;

import java.util.List;

import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;

public class ProductModel {
    public static enum Unit {
        UNIT, KILOGRAM, LITER, METER, PACK, BOX
    }

    private String id;

    private String name;
    private Double price;

    private Unit unit;

    private List<OrderDetailsModel> orderDetails;

    private ProductCatalogModel  categoryProduct;

    private DistributorModel distributor;

    public ProductModel(String id, String name, Double price, Unit unit, List<OrderDetailsModel> orderDetails,
            ProductCatalogModel categoryProduct, DistributorModel distributor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.orderDetails = orderDetails;
        this.categoryProduct = categoryProduct;
        this.distributor = distributor;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public List<OrderDetailsModel> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsModel> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ProductCatalogModel getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(ProductCatalogModel categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public DistributorModel getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorModel distributor) {
        this.distributor = distributor;
    }

    
}
