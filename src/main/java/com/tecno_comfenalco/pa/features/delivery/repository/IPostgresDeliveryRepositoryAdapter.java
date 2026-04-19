package com.tecno_comfenalco.pa.features.delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.delivery.entity.postgres.DeliveryEntity;
import com.tecno_comfenalco.pa.features.delivery.mapper.PostgresDeliveryMapper;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.delivery.ports.IDeliveryRepositoryPort;
import com.tecno_comfenalco.pa.features.delivery.repository.postgres.IPostgresDeliveryRepository;

@Profile("postgres")
@Repository
public class IPostgresDeliveryRepositoryAdapter implements IDeliveryRepositoryPort {

    private final IPostgresDeliveryRepository repository;
    private final PostgresDeliveryMapper mapper;

    public IPostgresDeliveryRepositoryAdapter(IPostgresDeliveryRepository repository, PostgresDeliveryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DeliveryModel> findById(Long id) {
        return repository.findById(id)
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
        DeliveryEntity entity = mapper.toEntity(deliveryModel);
        DeliveryEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public boolean existsByDocumentNumber(Long documentNumber) {
        return repository.existsByDocumentNumber(documentNumber);
    }
}
