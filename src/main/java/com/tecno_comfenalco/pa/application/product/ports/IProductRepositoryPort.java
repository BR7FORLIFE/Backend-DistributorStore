package com.tecno_comfenalco.pa.application.product.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tecno_comfenalco.pa.domain.product.model.ProductModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

public interface IProductRepositoryPort {
    boolean existsByDistributorIdAndSku(UUID distributorId, String sku);

    boolean existsByProductIdAndDistributorId(UUID productId, UUID distributorId);

    ProductModel save(ProductModel productModel);

    void deleteProductByIdAndDistributorId(UUID productId, UUID distributorId);

    List<ProductModel> findAllPaged(UUID distributorId, Integer page, Integer size, String sortBy, String direction);

    Optional<ProductModel> findByProductId(UUID distributorId, UUID productId);

    List<ProductSummaryModel> findAllByIds(List<UUID> ids);
}
