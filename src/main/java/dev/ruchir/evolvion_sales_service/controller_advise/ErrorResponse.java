package dev.ruchir.evolvion_sales_service.controller_advise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String errorCode;
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String errorId;
    private Map<String, String> validationErrors; // Added field for validation errors
}
