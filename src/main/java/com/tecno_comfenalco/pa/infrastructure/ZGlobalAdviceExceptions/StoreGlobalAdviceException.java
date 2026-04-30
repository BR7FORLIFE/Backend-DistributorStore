package com.tecno_comfenalco.pa.infrastructure.ZGlobalAdviceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tecno_comfenalco.pa.application.store.exceptions.StoreAlreadyExistsException;
import com.tecno_comfenalco.pa.application.store.exceptions.StoreNotFoundException;
import com.tecno_comfenalco.pa.shared.utils.helper.ApiError;
import com.tecno_comfenalco.pa.shared.utils.helper.StaticError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class StoreGlobalAdviceException {

    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<ApiError> handleStoreNotFound(
            StoreNotFoundException ex,
            HttpServletRequest request) {
        return StaticError.buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(StoreAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleStoreAlreadyExists(
            StoreAlreadyExistsException ex,
            HttpServletRequest request) {
        return StaticError.buildError(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), request);
    }
}
