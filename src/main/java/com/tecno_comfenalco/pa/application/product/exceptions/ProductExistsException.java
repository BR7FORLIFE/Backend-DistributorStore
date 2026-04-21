package com.tecno_comfenalco.pa.application.product.exceptions;

import com.tecno_comfenalco.pa.application.GlobalApplicationException;

public class ProductExistsException extends GlobalApplicationException {

    public ProductExistsException() {
        super("Product already exists!");
    }
}
