# API de Gestión de Equipos

Este proyecto esta desarrollado con Spring Boot y forma parte de una prueba técnica. Permite gestionar equipos de fútbol con operaciones CRUD.

## Tecnologías utilizadas
- Java 17
- Spring Boot
- Maven
- H2 (Base de datos en memoria)
- JWT (Autenticación)
- Swagger / OpenAPI
- Docker y Docker Compose

## Ejecutar la aplicación

### 1. Requisitos
- Docker
- Docker Compose

### 2. Clonar el repositorio

```bash
git clone https://github.com/lisandrofunes/technicaltest.git
cd technicaltest
```

### 3. Variables de entorno
Las variables necesarias ya están definidas en el archivo .env.
Este archivo se incluye solo con fines prácticos para la prueba técnica.

### 4. Construir la imagen

```bash
docker compose build
```

### 5. Ejecutar

```bash
docker compose up spring-app
```

La aplicación estará disponible en: http://localhost:8080

Es posible utilizar la interfaz gráfica Swagger UI en:
http://localhost:8080/swagger-ui/index.html#/

### 6. Autenticación
- Endpoint de login: POST /auth/login
- Usuario por defecto: test
- Contraseña: 12345
- Luego de autenticarse, usar el botón Authorize en Swagger y pegar el token JWT recibido.
- Ya puedes probar los endpoints

### 7. Ejecutar Test

```bash
docker compose run --rm spring-tests
```bash
