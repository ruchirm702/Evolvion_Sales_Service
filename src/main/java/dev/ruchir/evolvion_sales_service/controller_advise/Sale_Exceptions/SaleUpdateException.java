package dev.ruchir.evolvion_sales_service.controller_advise.Sale_Exceptions;

public class SaleUpdateException extends RuntimeException {
    public SaleUpdateException(String message) {
        super(message);
    }

    public SaleUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
