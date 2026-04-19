package com.tecno_comfenalco.pa.features.product.ports;

import java.util.List;
import java.util.Optional;

import com.tecno_comfenalco.pa.features.product.models.ProductModel;

public interface IProductRepositoryPort {
    ProductModel save(ProductModel ProductModel);

    Optional<ProductModel> findById(String id);

    Optional<ProductModel> findByName(String name);

    List<ProductModel> findAll();

    boolean existsByName(String name);

    void deleteById(String id);
}
