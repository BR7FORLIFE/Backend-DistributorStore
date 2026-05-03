package com.tecno_comfenalco.pa.application.catalog.orchestator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.catalog.command.actions.AddCategoryToCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.AddProductToCategoryCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.CreateCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.GetProductByCategoryCommand;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddCategoryToCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddProductToCategoryCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.CreateCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.GetCatalogForAuthenticatedUserCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.GetProductByCategoryCommandResult;
import com.tecno_comfenalco.pa.application.catalog.exceptions.CatalogExistsException;
import com.tecno_comfenalco.pa.application.catalog.exceptions.CatalogNotFoundException;
import com.tecno_comfenalco.pa.application.catalog.exceptions.CategoryExistsException;
import com.tecno_comfenalco.pa.application.catalog.exceptions.CategoryNotFoundException;
import com.tecno_comfenalco.pa.application.catalog.exceptions.ProductExistsInCategoryException;
import com.tecno_comfenalco.pa.application.catalog.port.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.application.catalog.usecase.CatalogUseCase;
import com.tecno_comfenalco.pa.application.distributor.exceptions.DistributorNotFoundException;
import com.tecno_comfenalco.pa.application.distributor.ports.IDistributorRepositoryPort;
import com.tecno_comfenalco.pa.application.product.exceptions.ProductNotFoundException;
import com.tecno_comfenalco.pa.application.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.domain.distributor.model.DistributorModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

@Service
public class CatalogUseCaseImp implements CatalogUseCase {

    private final ICatalogRepositoryPort catalogRepositoryPort;
    private final IDistributorRepositoryPort distributorRepositoryPort;
    private final IProductRepositoryPort productRepositoryPort;

    public CatalogUseCaseImp(ICatalogRepositoryPort iCatalogRepositoryPort,
            IDistributorRepositoryPort distributorRepositoryPort,
            IProductRepositoryPort productRepositoryPort) {
        this.catalogRepositoryPort = iCatalogRepositoryPort;
        this.distributorRepositoryPort = distributorRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public CreateCatalogCommandResult createCatalog(CreateCatalogCommand cmd) {
        // encontramos a la distribuidora enlazada
        Optional<DistributorModel> optDistributor = distributorRepositoryPort.findByUserId(cmd.userDistributorId());

        if (optDistributor.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        String catalogNameLowercase = cmd.name().toLowerCase();

        boolean existsCatalog = catalogRepositoryPort.existsByDistributorIdAndCode(optDistributor.get().getId(),
                cmd.catalogCode());

        if (existsCatalog) {
            throw new CatalogExistsException();
        }

        CatalogModel newCatalog = CatalogModel.createDraft(optDistributor.get().getId(), cmd.catalogCode(),
                catalogNameLowercase,
                List.of());

        catalogRepositoryPort.save(newCatalog);

        return new CreateCatalogCommandResult(newCatalog, "Catalog created succesfull!");
    }

    @Override
    public AddCategoryToCatalogCommandResult addCategoryToCatalog(AddCategoryToCatalogCommand cmd) {
        // buscamos la distribuidora
        Optional<DistributorModel> optDistributor = distributorRepositoryPort.findByUserId(cmd.userDistributorId());

        if (optDistributor.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        boolean ownsCatalog = catalogRepositoryPort.existsByIdAndDistributorId(
                cmd.catalogId(),
                optDistributor.get().getId());

        if (!ownsCatalog) {
            throw new CatalogNotFoundException();
        }

        // vericamos que exista el catalogo
        boolean existsCatalog = catalogRepositoryPort.existsCatalogById(cmd.catalogId());

        if (!existsCatalog) {
            throw new CatalogNotFoundException();
        }

        String categoryLowercase = cmd.name().toLowerCase();

        boolean existsCategory = catalogRepositoryPort.existsCategoryByDistributorIdAndName(
                cmd.catalogId(),
                categoryLowercase);

        if (existsCategory) {
            throw new CategoryExistsException();
        }

        CategoryModel categoryModel = CategoryModel.createDraft(categoryLowercase, null);

        catalogRepositoryPort.addCategoryToCatalog(cmd.catalogId(), categoryModel);

        return new AddCategoryToCatalogCommandResult(
                cmd.catalogId(),
                categoryModel.getId(),
                "Category added succesfull!");
    }

    @Override
    public AddProductToCategoryCommandResult addProductToCategory(AddProductToCategoryCommand cmd) {
        // validamos que exista la distribuidora
        Optional<DistributorModel> optDistributor = distributorRepositoryPort.findByUserId(cmd.userDistributorId());

        if (optDistributor.isEmpty()) {
            throw new DistributorNotFoundException();
        }

        boolean ownsCatalog = catalogRepositoryPort.existsByIdAndDistributorId(
                cmd.catalogId(),
                optDistributor.get().getId());

        if (!ownsCatalog) {
            throw new CatalogNotFoundException();
        }

        // validamos que exista el catalogo
        boolean existsCatalog = catalogRepositoryPort.existsCatalogById(cmd.catalogId());

        if (!existsCatalog) {
            throw new CatalogNotFoundException();
        }

        // validamos que exista la categoria
        boolean existsCategory = catalogRepositoryPort.existsCategoryByCatalogIdAndCategoryId(
                cmd.catalogId(),
                cmd.categoryId());

        if (!existsCategory) {
            throw new CategoryNotFoundException();
        }

        // validamos que exista el producto
        Optional<ProductModel> optProduct = productRepositoryPort.findByProductId(
                optDistributor.get().getId(),
                cmd.productId());

        if (optProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        // validar si un producto no ha sido agregado a una categoria
        boolean existsProductIntoCategory = catalogRepositoryPort.existsByIdAndCategoriesIdAndCategoriesProductsId(
                cmd.catalogId(),
                cmd.categoryId(),
                optProduct.get().getId());

        if (existsProductIntoCategory) {
            throw new ProductExistsInCategoryException();
        }

        ProductSummaryModel summaryProduct = new ProductSummaryModel(
                optProduct.get().getId(),
                optProduct.get().getSku(),
                optProduct.get().getName(),
                optProduct.get().getUnit(),
                optProduct.get().getPrice());

        catalogRepositoryPort.addProductToCategory(cmd.categoryId(), summaryProduct);

        return new AddProductToCategoryCommandResult("product added succesfull!");
    }

    @Override
    public GetCatalogForAuthenticatedUserCommandResult getCatalogForAuthenticatedUser() {
        throw new UnsupportedOperationException("Unimplemented method 'getCatalogForAuthenticatedUser'");
    }

    @Override
    public GetProductByCategoryCommandResult getProductsByCategory(GetProductByCategoryCommand cmd) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategory'");
    }

}
