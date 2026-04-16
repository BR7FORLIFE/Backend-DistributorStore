package com.tecno_comfenalco.pa.features.category.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.category.entity.postgres.CategoryEntity;

public interface IPostgresCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity save(CategoryEntity categoryEntity);

    Optional<CategoryEntity> findById(Long id);

    List<CategoryEntity> findByCatalog_Id(Long catalogId);
}
