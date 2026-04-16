package com.tecno_comfenalco.pa.features.product.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public interface IProductRepositoryPort {
    ProductModel save(ProductModel ProductModel);

    Optional<ProductModel> findById(UUID id);

    Optional<ProductModel> findByName(String name);

    List<ProductModel> findAll();

    List<ProductModel> findByCategoryProduct_Category_Id(Long id);

    boolean existsByName(String name);

    void deleteById(UUID id);
}
