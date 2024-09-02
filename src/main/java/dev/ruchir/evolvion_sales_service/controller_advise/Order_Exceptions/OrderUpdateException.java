package dev.ruchir.evolvion_sales_service.controller_advise.Order_Exceptions;

public class OrderUpdateException extends RuntimeException {
    public OrderUpdateException(String message) {
        super(message);
    }

    public OrderUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}