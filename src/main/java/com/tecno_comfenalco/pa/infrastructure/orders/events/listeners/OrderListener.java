package com.tecno_comfenalco.pa.infrastructure.orders.events.listeners;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.tecno_comfenalco.pa.application.orders.events.OrderRejectedEvent;
import com.tecno_comfenalco.pa.infrastructure.inventory.entity.InventoryDocument;

@Component
public class OrderListener {

    private final MongoTemplate mongoTemplate;

    public OrderListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Este metodo asincrono nos permitira regresar el stock cuando un pedido ha
     * sido rechazado!
     */
    @Async
    @EventListener
    public void updateStockWhenOrderIdDeleted(OrderRejectedEvent orderDeleteEvent) {
        orderDeleteEvent.orderProducts().stream().forEach(orderProduct -> {
            updateStock(
                    orderDeleteEvent.distributorId(),
                    orderProduct.getProductId(),
                    orderProduct.getQuantity());
        });
    }

    public void updateStock(UUID distributorId, UUID productId, Long delta) {
        Query query = new Query(Criteria.where("distributorId").is(distributorId)
                .and("productId").is(productId));

        Update update = new Update().inc("quantity", Math.abs(delta));

        mongoTemplate.updateFirst(query, update, InventoryDocument.class);

        System.out.println("se ha sumado el stock al pedido eliminado!");
    }
}
