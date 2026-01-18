# Bookstore Service

Spring Boot REST API that provides CRUD operations for a `Book` entity.

## Requirements

- Java 21
- Maven 3.9+

## Running

```bash
mvn spring-boot:run
```

The service starts on `http://localhost:8080` and exposes H2 console at `/h2-console`.

## API

### Create a book

```bash
curl -X POST http://localhost:8080/api/books \
  -H 'Content-Type: application/json' \
  -d '{"name":"Clean Code","author":"Robert C. Martin","writedTime":"2008-08-01"}'
```

### List books

```bash
curl http://localhost:8080/api/books
```

### Get book by id

```bash
curl http://localhost:8080/api/books/1
```

### Update a book

```bash
curl -X PUT http://localhost:8080/api/books/1 \
  -H 'Content-Type: application/json' \
  -d '{"name":"Clean Code","author":"Robert C. Martin","writedTime":"2008-08-01"}'
```

### Delete a book

```bash
curl -X DELETE http://localhost:8080/api/books/1
```
