package dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions;

public class SaleCreationException extends RuntimeException {
    public SaleCreationException(String message) {
        super(message);
    }

    public SaleCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
