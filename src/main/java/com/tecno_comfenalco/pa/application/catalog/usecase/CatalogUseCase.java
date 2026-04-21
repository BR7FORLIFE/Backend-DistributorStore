package com.tecno_comfenalco.pa.application.catalog.usecase;

import com.tecno_comfenalco.pa.application.catalog.command.actions.AddCategoryToCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.AddProductToCategoryCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.CreateCatalogCommand;
import com.tecno_comfenalco.pa.application.catalog.command.actions.GetProductByCategoryCommand;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddCategoryToCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.AddProductToCategoryCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.CreateCatalogCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.GetCatalogForAuthenticatedUserCommandResult;
import com.tecno_comfenalco.pa.application.catalog.command.responses.GetProductByCategoryCommandResult;

public interface CatalogUseCase {
    AddCategoryToCatalogCommandResult addCategoryToCatalog(AddCategoryToCatalogCommand cmd);

    AddProductToCategoryCommandResult addProductToCategory(AddProductToCategoryCommand cmd);

    GetCatalogForAuthenticatedUserCommandResult getCatalogForAuthenticatedUser();

    GetProductByCategoryCommandResult getProductsByCategory(GetProductByCategoryCommand cmd);

    CreateCatalogCommandResult createCatalog(CreateCatalogCommand cmd);
}
