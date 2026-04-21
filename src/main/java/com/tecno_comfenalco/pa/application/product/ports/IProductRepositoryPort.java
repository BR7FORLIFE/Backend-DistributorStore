package com.tecno_comfenalco.pa.application.product.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.product.model.ProductModel;

public interface IProductRepositoryPort {
    boolean existsByDistributorIdAndSku(UUID distributorId, String sku);

    boolean existsByProductIdAndDistributorId(UUID productId, UUID distributorId);

    ProductModel save(ProductModel productModel);

    void deleteProductByIdAndDistributorId(UUID productId, UUID distributorId);

    List<ProductModel> findAllPaged(UUID distributorId, int page, int size, String sortBy, String direction);

    Optional<ProductModel> findByProductId(UUID productId, UUID distributorId);
}
