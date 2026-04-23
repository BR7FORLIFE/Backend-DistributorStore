package com.tecno_comfenalco.pa.application.product.orchestator;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.product.command.actions.DisabledProductCommand;
import com.tecno_comfenalco.pa.application.product.command.actions.EditProductCommand;
import com.tecno_comfenalco.pa.application.product.command.actions.GetProductByIdCommand;
import com.tecno_comfenalco.pa.application.product.command.actions.ListProductCommand;
import com.tecno_comfenalco.pa.application.product.command.actions.RegisterProductCommand;
import com.tecno_comfenalco.pa.application.product.command.response.DisabledProductCommandResult;
import com.tecno_comfenalco.pa.application.product.command.response.EditProductCommandResult;
import com.tecno_comfenalco.pa.application.product.command.response.GetProductByIdCommandResult;
import com.tecno_comfenalco.pa.application.product.command.response.ListProductCommandResult;
import com.tecno_comfenalco.pa.application.product.command.response.RegisterProductCommandResult;
import com.tecno_comfenalco.pa.application.product.exceptions.ProductExistsException;
import com.tecno_comfenalco.pa.application.product.exceptions.ProductNotFoundException;
import com.tecno_comfenalco.pa.application.product.ports.IProductRepositoryPort;
import com.tecno_comfenalco.pa.application.product.usecases.ProductUseCase;
import com.tecno_comfenalco.pa.domain.product.model.ProductModel;

@Service
public class ProductUseCaseImp implements ProductUseCase {

    private final IProductRepositoryPort iProductRepositoryPort;

    public ProductUseCaseImp(IProductRepositoryPort iProductRepositoryPort) {
        this.iProductRepositoryPort = iProductRepositoryPort;
    }

    @Override
    public RegisterProductCommandResult registerProduct(RegisterProductCommand cmd) {
        boolean existsProduct = iProductRepositoryPort.existsByDistributorIdAndSku(cmd.distributorId(), cmd.sku());

        if (existsProduct) {
            throw new ProductExistsException();
        }
        ProductModel productModel = ProductModel.createDraft(cmd.distributorId(), cmd.sku(), cmd.name(), cmd.unit(),
                cmd.price());

        iProductRepositoryPort.save(productModel);

        return new RegisterProductCommandResult("Product created succesfull!");
    }

    @Override
    public EditProductCommandResult editProduct(EditProductCommand cmd) {

        boolean existsProduct = iProductRepositoryPort.existsByProductIdAndDistributorId(cmd.productId(),
                cmd.distributorId());

        if (!existsProduct) {
            throw new ProductNotFoundException();
        }

        ProductModel updateProduct = ProductModel.createNew(cmd.productId(), cmd.distributorId(), cmd.sku(), cmd.name(),
                cmd.unit(), cmd.price());

        iProductRepositoryPort.save(updateProduct);

        return new EditProductCommandResult(cmd.productId(), "Product update succesfull!");
    }

    @Override
    public DisabledProductCommandResult disabledProduct(DisabledProductCommand cmd) {
        boolean existsProduct = iProductRepositoryPort.existsByProductIdAndDistributorId(cmd.productId(),
                cmd.distributorId());

        if (!existsProduct) {
            throw new ProductNotFoundException();
        }

        iProductRepositoryPort.deleteProductByIdAndDistributorId(cmd.productId(), cmd.distributorId());

        return new DisabledProductCommandResult("Product delete succesfull!");
    }

    @Override
    public ListProductCommandResult listAll(ListProductCommand cmd) {
        List<ProductModel> products = iProductRepositoryPort.findAllPaged(cmd.distributorId(), cmd.page(), cmd.size(),
                cmd.sortBy(),
                cmd.direction());

        return new ListProductCommandResult(products, "Products obtain sucessfull");
    }

    @Override
    public GetProductByIdCommandResult getProductById(GetProductByIdCommand cmd) {
        Optional<ProductModel> product = iProductRepositoryPort.findByProductId(cmd.distributorId(), cmd.productId());

        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }

        return new GetProductByIdCommandResult(product.get(), "Product obtain succesfull!");
    }
}