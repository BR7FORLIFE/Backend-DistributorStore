package com.tecno_comfenalco.pa.features.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.category.entity.postgres.CategoryEntity;
import com.tecno_comfenalco.pa.features.category.mapper.PostgresCategoryMapper;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.features.category.ports.ICategoryRepositoryPort;
import com.tecno_comfenalco.pa.features.category.repository.postgres.IPostgresCategoryRepository;
import com.tecno_comfenalco.pa.shared.utils.helper.SafeParser;

@Profile("postgres")
@Repository
public class IPostgresCategoryRepositoryAdapter implements ICategoryRepositoryPort {

    private final IPostgresCategoryRepository repository;
    private final PostgresCategoryMapper mapper;

    public IPostgresCategoryRepositoryAdapter(IPostgresCategoryRepository repository, PostgresCategoryMapper mapper) {
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
    public Optional<CategoryModel> findById(String id) {
        Long parsedId = SafeParser.safeParseId(id);

        if (parsedId == null) {
            return Optional.empty();
        }
        return repository.findById(parsedId)
                .map(mapper::toDto);
    }

    @Override
    public List<CategoryModel> findByCatalog_Id(String id) {
        Long parseId = SafeParser.safeParseId(id);

        if (parseId == null) {
            return List.of();
        }

        return repository.findByCatalog_Id(parseId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
