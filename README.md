# Todoapi

Este es un ejercicio básico de API RESTful desarrollado con Spring Boot.

La API permite gestionar tareas (Tasks) con operaciones CRUD:  
- Crear  
- Leer  
- Actualizar  
- Eliminar  

## Tecnologías

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 Database (base de datos en memoria para pruebas)

## Endpoints

| Método  | Ruta         | Descripción                   |
|---------|--------------|-------------------------------|
| GET     | /tasks       | Obtener todas las tareas       |
| POST    | /tasks       | Crear una nueva tarea          |
| PUT     | /tasks/{id}  | Actualizar una tarea existente |
| DELETE  | /tasks/{id}  | Eliminar una tarea             |

## Cómo ejecutar

1. Clonar el repositorio  
2. Ejecutar `mvn spring-boot:run` para levantar la aplicación  
3. Acceder a los endpoints vía Postman o cualquier cliente HTTP en `http://localhost:8080/tasks`

---

Este proyecto es un ejercicio para aprender a construir APIs REST con Spring Boot y manejo básico de persistencia con JPA.

---

¡Contribuciones y sugerencias son bienvenidas!
