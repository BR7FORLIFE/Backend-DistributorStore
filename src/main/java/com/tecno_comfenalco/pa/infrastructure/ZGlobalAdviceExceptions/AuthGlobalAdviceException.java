package com.tecno_comfenalco.pa.infrastructure.ZGlobalAdviceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tecno_comfenalco.pa.application.auth.Exceptions.UserNotFoundException;
import com.tecno_comfenalco.pa.shared.utils.helper.ApiError;
import com.tecno_comfenalco.pa.shared.utils.helper.StaticError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AuthGlobalAdviceException {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(
            UserNotFoundException ex,
            HttpServletRequest request) {
        return StaticError.buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }
}
