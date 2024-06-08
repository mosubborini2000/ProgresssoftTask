# ProgressSoftTask - FX Deal Manager

## Overview

The FX Deal Manager is a component of a data warehouse system designed for Bloomberg to analyze foreign exchange (FX) deals. This documentation provides an overview of the system, its features, and how to use it.

## Features

1. **Acceptance of FX Deals:** Accepts details of FX deals, including deal unique ID, currency ISO codes, deal timestamp, and deal amount.
2. **Validation:** Validates the structure of each deal to ensure no missing fields and correct data types.
3. **Duplicate Prevention:** Prevents the import of duplicate deals to maintain data integrity.
4. **Persistence:** Persists FX deals into the database without rollback, ensuring all imported rows are saved.

## Technologies Used

The FX Deal Manager is developed using the following technologies:

- Java
- Spring Boot
- Gradle
- Postgres Database
- Docker

## Installation and Deployment

To install and deploy the FX Deal Manager, follow these steps:

1. **Clone the Repository:** Clone the repository from GitHub.
2. **Configure Database Settings:** Configure the database settings in the application properties file.
3. **Build and Create Docker Image:** Build the project using Gradle and create a Docker image of the application.
4. **Deploy Docker Image:** Deploy the Docker image using Docker Compose:
    - Open a terminal and navigate to the project directory.
    - Run the command `docker compose up` to start the application.
    - Access the application using the provided API endpoints.

## Testing

The FX Deal Manager is thoroughly tested using unit tests to ensure its functionality and reliability.

## API Endpoint

You can save a deal using the following API endpoint:

- **POST** `/api/v1/deals/save`: Save a deal by sending the deal details in the request body.

## Contact Information

For any inquiries or support related to the FX Deal Manager, please contact:

Email: mosubborini2000@gmail.com
Phone: 00962 7 8888 22 75

---
