package com.tecno_comfenalco.pa.features.category.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.category.models.CategoryModel;

public interface ICategoryRepositoryPort {
    CategoryModel save(CategoryModel categoryModel);

    Optional<CategoryModel> findById(Long id);

    List<CategoryModel> findByCatalog_Id(Long catalogId);
}
