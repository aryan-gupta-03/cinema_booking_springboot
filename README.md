# cinema_booking_springboot

Description

The Cinema Project API is a Spring Boot application that allows users to manage movies for a cinema system. Users can perform CRUD operations, filter movies by various criteria, and retrieve detailed movie information.

Prerequisites

Java 17 or later

Maven

Postman (for testing API endpoints)

MySQL or any configured database (ensure connection details are updated in application.properties)

Setup Instructions

Clone the Repository:

git clone <repository-url>
cd cinema_project

Build the Project:

mvn clean install

Run the Application:

mvn spring-boot:run

Access the Application:
The API will be running on http://localhost:8080.

API Endpoints

1. Add a New Movie

URL: /movies

Method: POST

Headers: Content-Type: application/json

Body Example:

{
"title": "Inception",
"description": "A mind-bending thriller.",
"director": "Christopher Nolan",
"genre": "Sci-Fi",
"date": "2010-07-16",
"location": "Los Angeles",
"totalSeats": 200,
"availableSeats": 150,
"price": 15
}

2. Get All Movies

URL: /movies

Method: GET

3. Get a Movie by ID

URL: /movies/{id}

Method: GET

4. Update a Movie

URL: /movies/{id}

Method: PUT

Headers: Content-Type: application/json

Body Example:

{
"title": "Inception",
"description": "A mind-bending thriller (Updated).",
"director": "Christopher Nolan",
"genre": "Sci-Fi",
"date": "2010-07-16",
"location": "Los Angeles",
"totalSeats": 200,
"availableSeats": 120,
"price": 18
}

5. Delete a Movie

URL: /movies/{id}

Method: DELETE

6. Get Movies by Genre

URL: /movies/genre/{genre}

Method: GET

7. Get Movies by Available Seats

URL: /movies/availableSeats/{minSeats}

Method: GET

8. Get Movies by Price Range

URL: /movies/priceRange/{minPrice}/{maxPrice}

Method: GET

9. Get Movies by Location

URL: /movies/location/{location}

Method: GET

10. Get Movies Sorted by Price

URL: /movies/sortedByPrice

Method: GET
