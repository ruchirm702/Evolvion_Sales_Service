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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSaleNotFoundException(SaleNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerRequirementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementNotFoundException(CustomerRequirementNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaleCreationException.class)
    public ResponseEntity<ErrorResponse> handleSaleCreationException(SaleCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaleUpdateException.class)
    public ResponseEntity<ErrorResponse> handleSaleUpdateException(SaleUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "SALE_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderCreationException.class)
    public ResponseEntity<ErrorResponse> handleOrderCreationException(OrderCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderUpdateException.class)
    public ResponseEntity<ErrorResponse> handleOrderUpdateException(OrderUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "ORDER_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerRequirementCreationException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementCreationException(CustomerRequirementCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_CREATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerRequirementUpdateException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequirementUpdateException(CustomerRequirementUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                "CUSTOMER_REQUIREMENT_UPDATE_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString()
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
                UUID.randomUUID().toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
