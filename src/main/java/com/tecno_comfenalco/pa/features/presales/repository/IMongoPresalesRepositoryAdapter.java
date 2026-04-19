package com.tecno_comfenalco.pa.features.presales.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;
import com.tecno_comfenalco.pa.features.presales.mapper.MongoPresalesMapper;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.features.presales.ports.IPresalesRepositoryPort;
import com.tecno_comfenalco.pa.features.presales.repository.mongo.IMongoPresalesRepository;

@Profile("mongo")
@Repository
public class IMongoPresalesRepositoryAdapter implements IPresalesRepositoryPort {

    private final IMongoPresalesRepository repository;
    private final MongoPresalesMapper mapper;

    public IMongoPresalesRepositoryAdapter(IMongoPresalesRepository repository,
            MongoPresalesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PresalesModel> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public Optional<PresalesModel> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDto);
    }

    @Override
    public Optional<PresalesModel> findByUser_Id(String userId) {
        return repository.findByUser_Id(userId)
                .map(mapper::toDto);
    }

    @Override
    public List<PresalesModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PresalesModel save(PresalesModel PresalesModel) {
        PresalesDocument presalesDocument = mapper.toEntity(PresalesModel);
        PresalesDocument saved = repository.save(presalesDocument);
        return mapper.toDto(saved);
    }

    @Override
    public boolean existsByDocumentNumber(Long documentNumber) {
        return repository.existsByDocumentNumber(documentNumber);
    }

}
