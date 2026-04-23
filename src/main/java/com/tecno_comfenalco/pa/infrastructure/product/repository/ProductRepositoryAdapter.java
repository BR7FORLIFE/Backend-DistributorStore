package com.tecno_comfenalco.pa.infrastructure.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.application.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.domain.product.model.ProductModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;
import com.tecno_comfenalco.pa.infrastructure.product.entity.ProductDocument;
import com.tecno_comfenalco.pa.infrastructure.product.mapper.ProductMapper;
import com.tecno_comfenalco.pa.infrastructure.product.mapper.ProductSummaryMapper;
import com.tecno_comfenalco.pa.infrastructure.product.repository.mongo.ProductRepository;

@Repository
public class ProductRepositoryAdapter implements IProductRepositoryPort {

    private final ProductRepository productRepository;

    public ProductRepositoryAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean existsByDistributorIdAndSku(UUID distributorId, String sku) {
        return productRepository.existsByDistributorIdAndSku(distributorId, sku);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        ProductDocument productDocument = ProductMapper.toEntity(productModel);
        ProductDocument saved = productRepository.save(productDocument);

        return ProductMapper.toDomain(saved);
    }

    @Override
    public void deleteProductByIdAndDistributorId(UUID productId, UUID distributorId) {
        productRepository.deleteByIdAndDistributorId(productId, distributorId);
    }

    @Override
    public boolean existsByProductIdAndDistributorId(UUID productId, UUID distributorId) {
        return productRepository.existsByIdAndDistributorId(productId, distributorId);
    }

    @Override
    public List<ProductModel> findAllPaged(UUID distributorId, Integer page, Integer size, String sortBy,
            String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Page<ProductDocument> result = productRepository.findByDistributorId(distributorId, pageable);

        return result.getContent()
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductModel> findByProductId(UUID distributorId, UUID productId) {
        return productRepository.findByDistributorIdAndId(distributorId, productId)
                .map(ProductMapper::toDomain);
    }

    @Override
    public List<ProductSummaryModel> findAllByIds(List<UUID> ids) {
        return productRepository.findAllById(ids)
                .stream()
                .map(ProductSummaryMapper::toSummary)
                .toList();
    }
}
