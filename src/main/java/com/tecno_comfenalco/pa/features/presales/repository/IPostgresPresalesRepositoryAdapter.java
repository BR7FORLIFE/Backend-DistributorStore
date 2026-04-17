package com.tecno_comfenalco.pa.features.presales.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.presales.entity.postgres.PresalesEntity;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.features.presales.ports.IPresalesRepositoryPort;
import com.tecno_comfenalco.pa.features.presales.repository.postgres.IPostgresPresalesRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("postgres")
@Repository
public class IPostgresPresalesRepositoryAdapter implements IPresalesRepositoryPort {

    private final IPostgresPresalesRepository repository;
    private final EntityMapper<PresalesModel, PresalesEntity> mapper;

    public IPostgresPresalesRepositoryAdapter(IPostgresPresalesRepository repository,
            EntityMapper<PresalesModel, PresalesEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PresalesModel> findById(String id) {
        return repository.findById(Long.parseLong(id)).map(mapper::toDto);
    }

    @Override
    public Optional<PresalesModel> findByName(String name) {
        return repository.findByName(name).map(mapper::toDto);
    }

    @Override
    public Optional<PresalesModel> findByUser_Id(String userId) {
        return repository.findByUser_Id(Long.parseLong(userId)).map(mapper::toDto);
    }

    @Override
    public List<PresalesModel> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PresalesModel save(PresalesModel PresalesModel) {
        return mapper.toDto(repository.save(mapper.toEntity(PresalesModel)));
    }

    @Override
    public boolean existsByDocumentNumber(Long documentNumber) {
        return repository.existsByDocumentNumber(documentNumber);
    }

}
