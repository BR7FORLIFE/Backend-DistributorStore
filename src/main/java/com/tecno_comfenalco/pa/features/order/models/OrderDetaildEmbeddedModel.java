package com.tecno_comfenalco.pa.features.order.models;


public class OrderDetaildEmbeddedModel {
    private String orderId;
    private String productId;

    public OrderDetaildEmbeddedModel() {
    }

    public OrderDetaildEmbeddedModel(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
