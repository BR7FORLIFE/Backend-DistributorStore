package com.tecno_comfenalco.pa.features.routes.models.delivery;

import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;

public class DeliveryRoutesModel {
    private Long id;

    private OrderModel orderEntity;

    private DeliveryModel delivery;

    public DeliveryRoutesModel(Long id, OrderModel orderEntity, DeliveryModel delivery) {
        this.id = id;
        this.orderEntity = orderEntity;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
