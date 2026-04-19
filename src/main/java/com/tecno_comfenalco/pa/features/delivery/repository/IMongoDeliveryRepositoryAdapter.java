package com.tecno_comfenalco.pa.features.delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;
import com.tecno_comfenalco.pa.features.delivery.mapper.MongoDeliveryMapper;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.features.delivery.repository.mongo.IMongoDeliveryRepository;

@Profile("mongo")
@Repository
public class IMongoDeliveryRepositoryAdapter implements IDeliveryRepositoryPort {

    private final IMongoDeliveryRepository repository;
    private final MongoDeliveryMapper mapper;

    public IMongoDeliveryRepositoryAdapter(IMongoDeliveryRepository repository, MongoDeliveryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DeliveryModel> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDto);
    }

    @Override
    public Optional<DeliveryModel> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDto);
    }

    @Override
    public List<DeliveryModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public DeliveryModel save(DeliveryModel deliveryModel) {
        DeliveryDocument document = mapper.toEntity(deliveryModel);
        DeliveryDocument saved = repository.save(document);
        return mapper.toDto(saved);
    }

    @Override
    public boolean existsByDocumentNumber(Long documentNumber) {
        return repository.existsByDocumentNumber(documentNumber.toString());
    }

}
