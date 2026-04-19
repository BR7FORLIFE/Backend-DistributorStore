package com.tecno_comfenalco.pa.features.order.models;

import java.util.List;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;

public class OrderModel {
    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELLED
    }

    private String id;

    private Double iva_percent;
    private Double total;

    private OrderStatus status;

    private StoreModel store;

    private PresalesModel presales;

    private List<OrderDetailsModel> orderDetails;

    private String distributorId;

    public OrderModel() {
    }

    public OrderModel(String id, Double iva_percent, Double total, OrderStatus status, StoreModel store,
            PresalesModel presales, List<OrderDetailsModel> orderDetails, String distributorId) {
        this.id = id;
        this.iva_percent = iva_percent;
        this.total = total;
        this.status = status;
        this.store = store;
        this.presales = presales;
        this.orderDetails = orderDetails;
        this.distributorId = distributorId;
    }

    public static OrderModel createDraft(
            Double ivaPercent,
            Double total,
            OrderStatus status,
            StoreModel store,
            PresalesModel presales,
            List<OrderDetailsModel> orderDetails,
            String distributorId) {

        return new OrderModel(
                UUID.randomUUID().toString(), 
                ivaPercent,
                total,
                status,
                store,
                presales,
                orderDetails,
                distributorId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getIva_percent() {
        return iva_percent;
    }

    public void setIva_percent(Double iva_percent) {
        this.iva_percent = iva_percent;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public StoreModel getStore() {
        return store;
    }

    public void setStore(StoreModel store) {
        this.store = store;
    }

    public PresalesModel getPresales() {
        return presales;
    }

    public void setPresales(PresalesModel presales) {
        this.presales = presales;
    }

    public List<OrderDetailsModel> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsModel> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

}
