package com.tecno_comfenalco.pa.features.routes.models.delivery;

import java.util.UUID;

import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;

public class DeliveryRoutesModel {
    private String id;

    private OrderModel orderEntity;

    private DeliveryModel delivery;

    public DeliveryRoutesModel(String id, OrderModel orderEntity, DeliveryModel delivery) {
        this.id = id;
        this.orderEntity = orderEntity;
        this.delivery = delivery;
    }

    public static DeliveryRoutesModel createDraft(
            OrderModel orderEntity,
            DeliveryModel delivery) {

        return new DeliveryRoutesModel(
                UUID.randomUUID().toString(),
                orderEntity,
                delivery);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderModel getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderModel orderEntity) {
        this.orderEntity = orderEntity;
    }

    public DeliveryModel getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryModel delivery) {
        this.delivery = delivery;
    }

}
