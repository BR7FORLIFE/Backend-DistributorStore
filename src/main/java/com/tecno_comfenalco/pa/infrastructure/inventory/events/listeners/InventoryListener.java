package com.tecno_comfenalco.pa.infrastructure.inventory.events.listeners;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.tecno_comfenalco.pa.application.orders.events.InventoryDiffEvent;
import com.tecno_comfenalco.pa.application.product.events.ProductDeletedEvent;
import com.tecno_comfenalco.pa.infrastructure.inventory.entity.InventoryDocument;

@Component
public class InventoryListener {
    private final MongoTemplate mongoTemplate;

    public InventoryListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Async
    @EventListener
    public void handleInventoryDelete(ProductDeletedEvent productEvent) {
        Query query = new Query(Criteria.where("productId").is(productEvent.id())
                .and("distributorId").is(productEvent.distributorId()));

        mongoTemplate.remove(query, InventoryDocument.class);
    }

    @Async
    @EventListener
    public void handleDiffInventoryByOrder(InventoryDiffEvent inventoryDiff) {
        inventoryDiff.orderProducts().stream().forEach(order -> {
            updateStock(inventoryDiff.distributorId(), order.getProductId(), order.getQuantity());
        });
    }

    public void updateStock(UUID distributorId, UUID productId, Long delta) {
        Query query = new Query(Criteria.where("distributorId").is(distributorId)
                .and("productId").is(productId));

        Update update = new Update().inc("quantity", -Math.abs(delta));

        mongoTemplate.updateFirst(query, update, InventoryDocument.class);
    }
}
