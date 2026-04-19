package com.tecno_comfenalco.pa.features.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;
import com.tecno_comfenalco.pa.features.category.mapper.MongoCategoryMapper;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.features.category.ports.ICategoryRepositoryPort;
import com.tecno_comfenalco.pa.features.category.repository.mongo.IMongoCategoryRepository;

@Profile("mongo")
@Repository
public class IMongoCategoryRepositoryAdapter implements ICategoryRepositoryPort {

    private final IMongoCategoryRepository repository;
    private final MongoCategoryMapper mapper;

    public IMongoCategoryRepositoryAdapter(IMongoCategoryRepository repository, MongoCategoryMapper mapper) {
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
    public Optional<CategoryModel> findById(String id) {
        return repository.findById(id.toString())
                .map(mapper::toDto);
    }

    @Override
    public List<CategoryModel> findByCatalog_Id(String id) {
        return findByCatalog_Id(id);
    }
}
