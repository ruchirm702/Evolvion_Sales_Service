# Evolvion_Sales_Service

## Overview
Evolvion Sales Service is a microservice developed as part of the Evolvion Business Management System. It manages sales, orders, and customer requirements, allowing businesses to track transactions, order statuses, and client preferences. This service integrates with other components like the Accounts Service to streamline operations.

## Key Features
- Sales Management: Create, update, and track sales with various payment methods and statuses.
- Order Tracking: Manage and update orders with multiple statuses and dynamic pricing.
- Customer Requirement Handling: Capture and manage customer preferences, types, and priorities.
- Enum-Based Categories: Flexible enums for payment methods, delivery options, and more.
- Data Validation: Ensures data integrity for all operations.
- Custom Exception Handling: Robust error handling with specific exceptions for sales, orders, and customer requirements.
- RESTful API: Easy integration with clear, well-structured endpoints.

## 🛠️ Project Structure

```plaintext
Evolvion_Sales_Service
├── controller
│   ├── SaleController
│   ├── OrderController
│   └── CustomerRequirementController
├── controller_advise
│   ├── Sale_Exceptions
│   ├── Order_Exceptions
│   ├── CustomerRequirement_Exceptions
│   ├── ErrorResponse
│   └── GlobalExceptionHandler
├── model
│   ├── core
│   └── enums
├── dto
│   ├── SaleDTO
│   ├── OrderDTO
│   └── CustomerRequirementDTO
├── mappers
│   ├── SaleMapper
│   ├── OrderMapper
│   └── CustomerRequirementMapper
├── repository
│   ├── SaleRepository
│   ├── OrderRepository
│   └── CustomerRequirementRepository
└── service
    ├── implementation
    │   ├── SaleServiceImpl
    │   ├── OrderServiceImpl
    │   └── CustomerRequirementServiceImpl
    └── interface
        ├── SaleService
        ├── OrderService
        └── CustomerRequirementService

```

## 🛠️ Services Overview

### 1. **Sale Service**
   - **Purpose:** Manages sales operations, including creation, updates, retrieval, and deletion of sales.
   - **Core Functionality:**
     - Create a new sale.
     - Update an existing sale.
     - Fetch details of a specific sale.
     - Retrieve a list of all sales.
     - Delete a sale by ID.

### 2. **Order Service**
   - **Purpose:** Handles orders related to sales, such as processing orders, managing order statuses, and tracking payments.
   - **Core Functionality:**
     - Create a new order.
     - Update an existing order.
     - Get details of a specific order.
     - Retrieve all orders.
     - Delete an order by ID.

### 3. **Customer Requirement Service**
   - **Purpose:** Manages customer-specific requirements, ensuring customer needs and priorities are addressed.
   - **Core Functionality:**
     - Create new customer requirements.
     - Update existing customer requirements.
     - Retrieve a specific customer requirement.
     - Fetch all customer requirements.
     - Delete a customer requirement by ID.


## 📦 Package Descriptions

### 1. **controller**
   - Contains RESTful controllers responsible for handling HTTP requests and directing them to the appropriate services.
   - **Files:**
     - `SaleController`: Manages sale-related endpoints.
     - `OrderController`: Handles order-related API requests.
     - `CustomerRequirementController`: Manages customer requirement-related operations.

### 2. **controller_advise**
   - Provides centralized exception handling for the application by using `@ControllerAdvice`.
   - **Files:**
     - `Sale_Exceptions`: Custom exceptions for Sale operations.
     - `Order_Exceptions`: Custom exceptions for Order operations.
     - `CustomerRequirement_Exceptions`: Custom exceptions for Customer Requirement operations.
     - `ErrorResponse`: Defines the structure of error responses.
     - `GlobalExceptionHandler`: Captures and handles exceptions thrown across the application.

### 3. **model**
   - Defines the core entities and enums used throughout the application.
   - **Files:**
     - `core`: Holds the entity models for `Sale`, `Order`, and `CustomerRequirement`.
     - `enums`: Contains enumerations for payment methods, statuses, customer priorities, etc.

### 4. **dto**
   - Contains Data Transfer Objects (DTOs) that are used to pass data between the controller and service layers.
   - **Files:**
     - `SaleDTO`: DTO for Sale data.
     - `OrderDTO`: DTO for Order data.
     - `CustomerRequirementDTO`: DTO for Customer Requirement data.

### 5. **mappers**
   - Provides mapper classes to convert between entities and DTOs.
   - **Files:**
     - `SaleMapper`: Maps between `Sale` entities and `SaleDTO`.
     - `OrderMapper`: Maps between `Order` entities and `OrderDTO`.
     - `CustomerRequirementMapper`: Maps between `CustomerRequirement` entities and `CustomerRequirementDTO`.

### 6. **repository**
   - Contains repository interfaces for database access, extending JPA repositories.
   - **Files:**
     - `SaleRepository`: Repository for Sale operations.
     - `OrderRepository`: Repository for Order operations.
     - `CustomerRequirementRepository`: Repository for Customer Requirement operations.

### 7. **service**
   - Defines the business logic of the application.
   - **Sub-packages:**
     - **Implementation:** Implements the service interfaces.
       - `SaleServiceImpl`: Implements sale operations.
       - `OrderServiceImpl`: Implements order operations.
       - `CustomerRequirementServiceImpl`: Implements customer requirement operations.
     - **Interface:** Defines the service interfaces.
       - `SaleService`: Interface for sale-related methods.
       - `OrderService`: Interface for order-related methods.
       - `CustomerRequirementService`: Interface for customer requirement-related methods.

## ⚠️ Exception Handling

Exception handling in the application is managed centrally using Spring's `@ControllerAdvice` and custom exception classes. This ensures a clean separation of concerns, allowing controllers to focus on business logic while delegating error handling to a centralized mechanism.

### 1. **Global Exception Handler**
   - The **GlobalExceptionHandler** class, annotated with `@ControllerAdvice`, captures exceptions thrown from any controller and handles them uniformly.
   - It ensures that specific exceptions are translated into meaningful HTTP responses, such as `400 Bad Request`, `404 Not Found`, or `500 Internal Server Error`.
   - **Key Methods**:
     - Handles common exceptions like `IllegalArgumentException`, `MethodArgumentNotValidException`, etc.
     - Customizes responses for business-specific exceptions.

### 2. **Custom Exception Classes**
   Custom exceptions are defined for each domain entity (Sale, Order, CustomerRequirement) to capture specific error scenarios.
   
   - **Sale_Exceptions**:
     - `SaleNotFoundException`: Thrown when a requested sale is not found.
     - `SaleCreationException`: Raised when the system encounters an issue during sale creation.
     - `SaleUpdateException`: Thrown when updating a sale fails.

   - **Order_Exceptions**:
     - `OrderNotFoundException`: Thrown when an order does not exist.
     - `OrderCreationException`: Raised if there’s an issue during order creation.
     - `OrderUpdateException`: Thrown when updating an order fails.

   - **CustomerRequirement_Exceptions**:
     - `CustomerRequirementNotFoundException`: Thrown when a customer requirement is not found.
     - `CustomerRequirementCreationException`: Raised during customer requirement creation errors.
     - `CustomerRequirementUpdateException`: Thrown when customer requirement updates fail.

### 3. **ErrorResponse**
   - The `ErrorResponse` class is used to encapsulate details of the error response sent to the client.
   - Contains fields like:
     - `timestamp`: The date and time when the error occurred.
     - `message`: A user-friendly message explaining the error.
     - `details`: Additional context or details about the error.

### 4. **Standardized Error Responses**
   - The `GlobalExceptionHandler` ensures that all exceptions return a well-structured `ErrorResponse` object.
   - This provides consistency and clarity to clients consuming the API, detailing the cause of errors with appropriate HTTP status codes (e.g., 404 for not found, 400 for bad request).

## ✅ Validation

DTO validation in the application is handled using Java Bean Validation (JSR 380) annotations provided by the `javax.validation` package. This ensures that incoming data is verified before reaching the service layer, helping maintain data integrity and preventing invalid input.

### Key Validation Features:
- **@NotNull**: Ensures that fields like `amount`, `quantity`, and `status` are not null.
- **@Size**: Limits the size of fields such as `saleNumber`, `orderNumber`, and `customerName` to prevent overly large inputs.
- **@Min / @Max**: Applies to numeric fields like `amount` and `price` to enforce valid ranges.
- **@PastOrPresent**: Validates date fields like `createdAt` and `updatedAt` to ensure they are not set in the future.

By leveraging these annotations, the system automatically triggers validation errors when invalid data is submitted, providing feedback through standardized error responses.


## 📄 Logging

The application uses **SLF4J** with **Logback** as the logging framework to capture important runtime events and errors. Logging is implemented across the services to ensure transparency in operations and to aid in debugging.

### Key Logging Features:
- **Info Logs**: Used to log significant business events, such as the creation or updating of a sale, order, or customer requirement.
- **Error Logs**: Captures exceptions and errors, especially in cases of service failures or invalid operations, ensuring detailed traceability.
- **Debug Logs**: Provides insights during development and debugging to track detailed internal operations.
- **Centralized Logging**: All logs are centrally managed, and log levels can be adjusted via `logback.xml` to suit different environments (development, testing, production).

This setup ensures efficient monitoring and quick resolution of issues during runtime.

## Contributing Guidelines

We welcome contributions to the Evolvion Accounts Service project! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with clear messages.
4. Push your changes to your fork.
5. Submit a pull request to the main repository.
