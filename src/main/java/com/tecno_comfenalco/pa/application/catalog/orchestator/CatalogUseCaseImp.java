package com.tecno_comfenalco.pa.application.catalog.orchestator;

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
import com.tecno_comfenalco.pa.application.catalog.usecase.CatalogUseCase;

@Service
public class CatalogUseCaseImp implements CatalogUseCase {

    @Override
    public CreateCatalogCommandResult createCategory(CreateCatalogCommand cmd) {
        return null;
    }

    @Override
    public AddCategoryToCatalogCommandResult addCategoryToCatalog(AddCategoryToCatalogCommand cmd) {
        



        return null;
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
