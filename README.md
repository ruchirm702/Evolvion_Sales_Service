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
