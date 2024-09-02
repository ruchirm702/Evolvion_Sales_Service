package dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions;

public class CustomerRequirementNotFoundException extends RuntimeException {
    public CustomerRequirementNotFoundException(String message) {
        super(message);
    }

    public CustomerRequirementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}