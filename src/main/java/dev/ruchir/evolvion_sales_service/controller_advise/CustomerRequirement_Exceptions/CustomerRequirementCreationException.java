package dev.ruchir.evolvion_sales_service.controller_advise.CustomerRequirement_Exceptions;

public class CustomerRequirementCreationException extends RuntimeException {
    public CustomerRequirementCreationException(String message) {
        super(message);
    }

    public CustomerRequirementCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}