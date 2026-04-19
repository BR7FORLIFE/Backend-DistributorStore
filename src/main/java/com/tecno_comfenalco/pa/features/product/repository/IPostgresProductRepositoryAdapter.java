package com.tecno_comfenalco.pa.features.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.product.entity.postgres.ProductEntity;
import com.tecno_comfenalco.pa.features.product.mapper.PostgresProductMapper;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.features.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.features.product.repository.postgres.IPostgresProductRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresProductRepositoryAdapter implements IProductRepositoryPort {

    private final IPostgresProductRepository repository;
    private final PostgresProductMapper mapper;

    public IPostgresProductRepositoryAdapter(IPostgresProductRepository repository, PostgresProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductModel save(ProductModel ProductModel) {
        ProductEntity entity = mapper.toEntity(ProductModel);
        ProductEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<ProductModel> findById(String id) {
        UUID parseId = SafeParser.safeParseUUID(id);

        if (parseId == null) {
            return Optional.empty();
        }

        return repository.findById(parseId).map(mapper::toDto);
    }

    @Override
    public Optional<ProductModel> findByName(String name) {
        return repository.findByName(name).map(mapper::toDto);
    }

    @Override
    public List<ProductModel> findAll() {
        List<ProductEntity> entities = repository.findAll();
        return mapper.toDto(entities);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void deleteById(String id) {
        UUID parseId = SafeParser.safeParseUUID(id);

        if (parseId == null) {
            return;
        }

        repository.deleteById(parseId);
    }

}
