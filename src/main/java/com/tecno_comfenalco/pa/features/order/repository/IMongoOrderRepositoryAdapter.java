package com.tecno_comfenalco.pa.features.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDocument;
import com.tecno_comfenalco.pa.features.order.models.OrderModel;
import com.tecno_comfenalco.pa.features.order.port.IOrderRepositoryPort;
import com.tecno_comfenalco.pa.features.order.repository.mongo.IMongoOrderRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("mongo")
@Repository
public class IMongoOrderRepositoryAdapter implements IOrderRepositoryPort {

    private final IMongoOrderRepository repository;
    private final EntityMapper<OrderModel, OrderDocument> mapper;

    public IMongoOrderRepositoryAdapter(IMongoOrderRepository repository, EntityMapper<OrderModel, OrderDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<OrderModel> findByid(String id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public OrderModel save(OrderModel OrderModel) {
        return mapper.toDto(repository.save(mapper.toEntity(OrderModel)));
    }

    @Override
    public List<OrderModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<OrderModel> findByStore_Id(String storeId) {
        return mapper.toDto(repository.findByStore_Id(storeId));
    }

    @Override
    public List<OrderModel> findByPresales_Id(String presalesId) {
        return mapper.toDto(repository.findByPresales_Id(presalesId));
    }

    @Override
    public boolean existsByid(String id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
