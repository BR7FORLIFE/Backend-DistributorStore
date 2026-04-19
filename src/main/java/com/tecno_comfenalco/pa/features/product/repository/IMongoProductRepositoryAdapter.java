package com.tecno_comfenalco.pa.features.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;
import com.tecno_comfenalco.pa.features.product.mapper.MongoProductMapper;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.features.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.features.product.repository.mongo.IMongoProductRepository;

@Profile("mongo")
@Repository
public class IMongoProductRepositoryAdapter implements IProductRepositoryPort {

    private final IMongoProductRepository repository;
    private final MongoProductMapper mapper;

    public IMongoProductRepositoryAdapter(IMongoProductRepository repository,
            MongoProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductModel save(ProductModel ProductModel) {
        ProductDocument document = mapper.toEntity(ProductModel);
        ProductDocument savedDocument = repository.save(document);
        return mapper.toDto(savedDocument);
    }

    @Override
    public Optional<ProductModel> findById(String id) {
        Optional<ProductDocument> documentOpt = repository.findById(id);
        return documentOpt.map(mapper::toDto);
    }

    @Override
    public Optional<ProductModel> findByName(String name) {
        Optional<ProductDocument> documentOpt = repository.findByName(name);
        return documentOpt.map(mapper::toDto);
    }

    @Override
    public List<ProductModel> findAll() {
        List<ProductDocument> documents = repository.findAll();
        return mapper.toDto(documents);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
