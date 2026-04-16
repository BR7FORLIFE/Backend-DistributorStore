package com.tecno_comfenalco.pa.features.order.models;

import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public class OrderDetailsModel {
    private String id;

    private OrderModel order;

    private ProductModel product;

    private Integer quantity;

    private Double unitPrice;

    public OrderDetailsModel() {
    }

    public OrderDetailsModel(String id, OrderModel order, ProductModel product, Integer quantity, Double unitPrice) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
