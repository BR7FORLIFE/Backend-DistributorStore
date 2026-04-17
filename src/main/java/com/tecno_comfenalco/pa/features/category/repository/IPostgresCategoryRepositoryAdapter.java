package com.tecno_comfenalco.pa.features.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.category.entity.postgres.CategoryEntity;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.features.category.ports.ICategoryRepositoryPort;
import com.tecno_comfenalco.pa.features.category.repository.postgres.IPostgresCategoryRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("postgres")
@Repository
public class IPostgresCategoryRepositoryAdapter implements ICategoryRepositoryPort {

    private final IPostgresCategoryRepository repository;
    private final EntityMapper<CategoryModel, CategoryEntity> mapper;

    public IPostgresCategoryRepositoryAdapter(IPostgresCategoryRepository repository, EntityMapper<CategoryModel, CategoryEntity> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        CategoryEntity entity = mapper.toEntity(categoryModel);
        CategoryEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<CategoryModel> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public List<CategoryModel> findByCatalog_Id(Long catalogId) {
        return mapper.toDto(repository.findByCatalog_Id(catalogId));

    }

}
