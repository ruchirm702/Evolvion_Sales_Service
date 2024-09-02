package dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions;

public class CustomerRequirementUpdateException extends RuntimeException {
    public CustomerRequirementUpdateException(String message) {
        super(message);
    }

    public CustomerRequirementUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
