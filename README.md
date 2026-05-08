# SpringBoot CRUD

A simple CRUD application built with Spring Boot using layered architecture and PostgreSQL.

## Stack
- Java 23
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Thymeleaf
- Docker
- Maven

## Functionality
- Create user
- Update user
- Delete user
- View all users
- REST API endpoints
- Web interface with Thymeleaf
- DTO mapping
- Form handling and validation
- PostgreSQL persistence

## Architecture
Project follows layered architecture:

Controller → Service → Repository → Database

Separate controllers were implemented for:
- REST API
- Web pages (Thymeleaf)

## Database
PostgreSQL runs inside Docker container.

## Run application

Start PostgreSQL:

```bash
docker compose up -d
