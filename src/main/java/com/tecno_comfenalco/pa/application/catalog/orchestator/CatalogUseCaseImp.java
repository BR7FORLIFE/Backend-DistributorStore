package com.tecno_comfenalco.pa.application.catalog.orchestator;

import java.util.ArrayList;
import java.util.List;

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
import com.tecno_comfenalco.pa.application.catalog.exceptions.CategoryExistsException;
import com.tecno_comfenalco.pa.application.catalog.port.ICatalogRepositoryPort;
import com.tecno_comfenalco.pa.application.catalog.usecase.CatalogUseCase;
import com.tecno_comfenalco.pa.application.product.exceptions.ProductNotFoundException;
import com.tecno_comfenalco.pa.application.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.domain.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.domain.product.model.ProductSummaryModel;

@Service
public class CatalogUseCaseImp implements CatalogUseCase {

    private final ICatalogRepositoryPort catalogRepositoryPort;
    private final IProductRepositoryPort iProductRepositoryPort;

    public CatalogUseCaseImp(ICatalogRepositoryPort iCatalogRepositoryPort,
            IProductRepositoryPort iProductRepositoryPort) {
        this.catalogRepositoryPort = iCatalogRepositoryPort;
        this.iProductRepositoryPort = iProductRepositoryPort;
    }

    @Override
    public CreateCatalogCommandResult createCatalog(CreateCatalogCommand cmd) {
        String catalogNameLowercase = cmd.name().toLowerCase();

        boolean existsCatalog = catalogRepositoryPort.existsByDistributorIdAndCode(cmd.distributorId(),
                cmd.catalogCode());

        if (existsCatalog) {
            throw new CatalogExistsException();
        }

        CatalogModel newCatalog = CatalogModel.createDraft(cmd.distributorId(), cmd.catalogCode(), catalogNameLowercase,
                List.of());

        catalogRepositoryPort.save(newCatalog);

        return new CreateCatalogCommandResult(newCatalog, "Catalog created succesfull!");
    }

    @Override
    public AddCategoryToCatalogCommandResult addCategoryToCatalog(AddCategoryToCatalogCommand cmd) {
        String categoryLowercase = cmd.name().toLowerCase();

        boolean existsCategory = catalogRepositoryPort.existsCategoryNameInCatalog(cmd.catalogId(), categoryLowercase);

        if (existsCategory) {
            throw new CategoryExistsException();
        }

        List<ProductSummaryModel> summaries = new ArrayList<>();

        if (cmd.products() != null && !cmd.products().isEmpty()) {
            summaries = iProductRepositoryPort.findAllByIds(cmd.products());

            if (summaries.size() != cmd.products().size()) {
                throw new ProductNotFoundException();
            }
        }

        CategoryModel categoryModel = CategoryModel.createDraft(categoryLowercase, summaries);

        catalogRepositoryPort.addCategoryToCatalog(cmd.catalogId(), categoryModel);

        return new AddCategoryToCatalogCommandResult("Category added succesfull!");
    }

    @Override
    public AddProductToCategoryCommandResult addProductToCategory(AddProductToCategoryCommand cmd) {
        throw new UnsupportedOperationException("Unimplemented method 'addProductToCategory'");
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
