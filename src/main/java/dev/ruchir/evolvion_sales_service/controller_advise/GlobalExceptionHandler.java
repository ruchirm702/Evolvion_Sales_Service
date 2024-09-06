package dev.ruchir.evolvion_sales_service.controller_advise;

import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions.CustomerRequirementUpdateException;
import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions.OrderUpdateException;
import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleCreationException;
import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleNotFoundException;
import dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions.SaleUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation errors (DTO validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();

        // Collect field errors
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // Include validationErrors in ErrorResponse
        ErrorResponse errorResponse = new ErrorResponse(
                "Validation failed",
                "VALIDATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                validationErrors
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle SaleNotFoundException
    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSaleNotFoundException(SaleNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle SaleCreationException
    @ExceptionHandler(SaleCreationException.class)
    public ResponseEntity<ErrorResponse> handleSaleCreationException(SaleCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle SaleUpdateException
    @ExceptionHandler(SaleUpdateException.class)
    public ResponseEntity<ErrorResponse> handleSaleUpdateException(SaleUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle OrderNotFoundException
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle OrderCreationException
    @ExceptionHandler(OrderCreationException.class)
    public ResponseEntity<ErrorResponse> handleOrderCreationException(OrderCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle OrderUpdateException
    @ExceptionHandler(OrderUpdateException.class)
    public ResponseEntity<ErrorResponse> handleOrderUpdateException(OrderUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle CustomerRequirementNotFoundException
    @ExceptionHandler(CustomerRequirementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementNotFoundException(CustomerRequirementNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle CustomerRequirementCreationException
    @ExceptionHandler(CustomerRequirementCreationException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementCreationException(CustomerRequirementCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle CustomerRequirementUpdateException
    @ExceptionHandler(CustomerRequirementUpdateException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementUpdateException(CustomerRequirementUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle other exceptions globally
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "An unexpected error occurred.",
                "INTERNAL_SERVER_ERROR",
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                UUID.randomUUID().toString(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
