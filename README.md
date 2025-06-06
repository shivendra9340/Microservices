# 🧩 Microservices Project with Spring Boot

This repository contains a complete microservices-based application built using **Spring Boot**, **Spring Cloud**, and **Netflix Eureka**. Each module (Post, Comment, Gateway, and Server Service) is designed to be scalable, maintainable, and independently deployable.

---

## 📦 Services Overview

### 🔹 1. API Gateway (`api_gateway`)
- Acts as the single entry point for all client requests.
- Routes requests to appropriate microservices using **Spring Cloud Gateway**.
- Integrated with **Eureka Client** for service discovery.

### 🔹 2. Post Service (`post`)
- Manages blog or user posts.
- Performs CRUD operations using Spring Data JPA.
- Connected to a MySQL database.

### 🔹 3. Comment Service (`comment`)
- Handles comments on posts.
- Performs CRUD operations with MySQL.
- Registered with Eureka for dynamic service discovery.

### 🔹 4. Eureka Server (`server-service`)
- Centralized **service registry** using **Spring Cloud Netflix Eureka**.
- All microservices register here for load balancing and discovery.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Cloud 2023.0 / 2024.0**
- **Eureka Server & Eureka Client**
- **Spring Cloud Gateway**
- **Spring Data JPA**
- **MySQL**
- **Lombok**

---

## 📂 Folder Structure

├── api_gateway/
├── comment/
├── post/
├── server-service/
├── *.zip (optional zipped services)


---

## 🚀 Getting Started

### Prerequisites:
- Java 17
- Maven 3.8+
- MySQL running on your local system
- Eureka Server running before other services

### Step-by-step:

1. **Clone the repository**
   ```bash
   git clone https://github.com/shivendra9340/Microservices.git
   cd Microservices
2. Start Eureka Server
   cd server-service/server-service
mvn spring-boot:run

3. Start API Gateway
   cd api_gateway
mvn spring-boot:run
4. Start Post and Comment Services
   cd post
mvn spring-boot:run

cd ../comment
mvn spring-boot:run

🌐 Service Discovery (Eureka Dashboard)
Once running, visit:
http://localhost:8761
Here you'll see all registered services.

🧪 API Testing (Postman)
You can test the services via API Gateway like:

GET http://localhost:8080/post/posts

GET http://localhost:8080/comment/comments

Make sure routes are configured correctly in the gateway.

📌 Author
👤 Shivendra Ojha
Email: shivendraojha370@gmail.com
GitHub: shivendra9340
