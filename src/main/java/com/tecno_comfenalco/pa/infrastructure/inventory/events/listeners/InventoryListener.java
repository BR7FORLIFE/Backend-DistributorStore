package com.tecno_comfenalco.pa.infrastructure.inventory.events.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
}
