package com.tecno_comfenalco.pa.features.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.features.category.ports.ICategoryRepositoryPort;
import com.tecno_comfenalco.pa.features.category.repository.mongo.IMongoCategoryRepository;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("mongo")
@Repository
public class IMongoCategoryRepositoryAdapter implements ICategoryRepositoryPort {

    private final IMongoCategoryRepository repository;
    private final EntityMapper<CategoryModel, CategoryDocument> mapper;

    public IMongoCategoryRepositoryAdapter(IMongoCategoryRepository repository, EntityMapper<CategoryModel, CategoryDocument> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        CategoryDocument document = mapper.toEntity(categoryModel);
        CategoryDocument saved = repository.save(document);

        return mapper.toDto(saved);
    }

    @Override
    public Optional<CategoryModel> findById(Long id) {
        return repository.findById(id.toString())
                .map(mapper::toDto);
    }

    @Override
    public List<CategoryModel> findByCatalog_Id(Long catalogId) {
        return mapper.toDto(repository.findByCatalog_Id(catalogId.toString()));
    }

}
