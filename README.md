# URL Hit Counter

This project implements a simple URL hit counter feature using Spring Boot.

## Framework and Language Used

- Framework: Spring Boot
- Language: Java

## Data Flow

The data flow in this project follows the typical architecture of a Spring Boot application, with the following components:

- Controller: The `UrlHitController` class handles incoming HTTP requests and delegates the processing to the service layer.
- Service: The `UrlHitService` class contains the business logic and interacts with the repository (in-memory `ArrayList` in this case) to manage the hit counts.
- Repository: The in-memory `ArrayList` is used as a simple "database" to store the hit count data for each user.

The data flow can be summarized as follows:

1. The incoming HTTP request is received by the `UrlHitController`.
2. The `UrlHitController` calls the appropriate method in the `UrlHitService`.
3. The `UrlHitService` retrieves or updates the hit count data from the repository (the `ArrayList`).
4. The response is prepared and sent back to the client.

## Data Structure Used

The project uses the following data structure:

- `ArrayList`: The in-memory `ArrayList` is used as a simple "database" to store instances of the `HitCountData` class. Each instance represents a user's hit count data, including the username and hit count.

## Project Summary

The URL Hit Counter feature is a simple Spring Boot application that allows tracking the hit counts for each URL and user. It provides the following functionality:

- `/api/v1/visitor-count-app/count`: Retrieves the overall hit count for all visitors.
- `/api/v1/visitor-count-app/username/{username}/count`: Retrieves the hit count for a specific user identified by their username.

The project showcases the use of Spring Boot and demonstrates the separation of concerns through the controller, service, and repository layers. The hit count data is stored in an in-memory `ArrayList` for simplicity.

