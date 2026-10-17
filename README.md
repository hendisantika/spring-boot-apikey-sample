# spring-boot-apikey-sample

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-apikey-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-apikey-sample/actions/workflows/maven.yml)

A sample Spring Boot application that secures REST endpoints with an **API key** passed in a request header,
implemented as a custom Spring Security filter backed by an H2 database.

## Tech Stack

- Java 25
- Spring Boot 4.1.1 (Web MVC, Security, Data JPA, Actuator)
- H2 in-memory database
- Lombok
- Java Faker
- Maven 3.10 (wrapper included)

## How It Works

- `ApiKeyFilter` runs for every request whose path starts with `app.filters.apikey.pathPrefix` (default `/api`).
- It reads the `Api-Key` header and looks it up in the `client_credentials` table.
- A valid key marks the request as authenticated; a missing or unknown key returns `401 Unauthorized`.
- Sessions are stateless. `/web/home`, `/error` and `/h2-console/**` are publicly accessible.

The database is created from `schema.sql` and seeded from `data.sql` with one key:

```
5c8d56a2-88b2-48a7-aec8-c9a8ac7af99a
```

## Endpoints

| Method | Path          | Auth            | Description                     |
|--------|---------------|-----------------|---------------------------------|
| GET    | `/web/home`   | Public          | Welcome message with timestamp  |
| GET    | `/api/quotes` | `Api-Key` header | Returns a random Chuck Norris fact |

## Requirements

- JDK 25

## Run

```bash
./mvnw spring-boot:run
```

## Try It

Public endpoint:

```bash
curl http://localhost:8080/web/home
```

```json
{"success":true,"code":200,"message":"Welcome to Bandung","data":{"timestamp":1760659200000}}
```

Protected endpoint with a valid key:

```bash
curl -H "Api-Key: 5c8d56a2-88b2-48a7-aec8-c9a8ac7af99a" http://localhost:8080/api/quotes
```

```json
{"success":true,"code":200,"message":"Operation Successful","data":{"quote":"..."}}
```

Without a key, or with an invalid one, the API responds with `401 Unauthorized`:

```bash
curl -i http://localhost:8080/api/quotes
```

## Configuration

`src/main/resources/application.properties`:

| Property                         | Default | Description                                      |
|----------------------------------|---------|--------------------------------------------------|
| `app.filters.apikey.pathPrefix`  | `/api`  | Path prefix that requires a valid `Api-Key` header |

## Test

```bash
./mvnw test
```

## CI

GitHub Actions (`.github/workflows/maven.yml`) builds and tests the project on JDK 25 (Temurin) for every push and
pull request to `main`.
