# <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java Logo" width="40" height="40"/> Taller JWT - Entornos de Programación G1 - UIS: 

## Introducción

Este repositorio contiene una aplicación web básica desarrollada con `HTML`, `CSS` y `JavaScript clásico`. En esta ocasión, no se utilizaron frameworks como React ni servidores como Nginx para su despliegue.  

El backend se implementó como una API REST utilizando `Spring Boot`, con un enfoque específico en la integración de `Spring Security` y `JWT` para gestionar la autenticación y el control de acceso de los usuarios. 

---

## 🧰 Tecnologías Usadas

| Tecnología      | Versión    | Detalles                                   |
|-----------------|------------|-------------------------------------------|
| ![Java](https://img.shields.io/badge/Java-17-blue?logo=java)            | JDK 17     | Kit de Desarrollo de Java (JDK)         |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.9-brightgreen?logo=springboot) | 3.1.9      | Framework Spring Boot                    |
| ![Swagger](https://img.shields.io/badge/Swagger-2.3.0-yellowgreen?logo=swagger)        | 2.3.0      | Documentación de la API                  |
| ![JWT](https://img.shields.io/badge/JWT-0.12.5-red?logo=jsonwebtokens) | 0.12.5 | Aautenticación con JSON Web Token (JWT) |
| ![NetBeans](https://img.shields.io/badge/NetBeans-22-lightgrey?logo=apache-netbeans-ide)   | 22         | IDE utilizado para el desarrollo         |
| ![Ubuntu](https://img.shields.io/badge/Ubuntu-22.04-orange?logo=ubuntu)        | 22.04      | Sistema operativo                        |

---

## 📂 Base de Datos

La base de datos está compuesta por tres tablas principales:  

- **`tipoDocumento`**: Contiene los diferentes tipos de documentos de identidad, como C.C (Cédula de Ciudadanía), C.E (Cédula de Extranjería), T.I (Tarjeta de Identidad), entre otros.  
- **`usuario`**: Tabla donde se almacenan los datos de los usuarios, incluyendo su `userName` y `contraseña`, los cuales son utilizados para el inicio de sesión.  
- **`proveedor`**: Tabla auxiliar utilizada para probar endpoints protegidos, que requieren un token válido para su acceso.  

El script para la creación de la base de datos se encuentra en la siguiente ruta:  

#### 📄 **[Script SQL](./Scripts%20SQL/creacionDB.sql)** – Script para la creación de la DB

---

## ⚙️ Instrucciones para Compilar y Ejecutar

### Compilar el archivo JAR:
```bash
cd Back/TallerJWT
mvn clean install
```

### Ejecutar la aplicación:
```bash
java -jar target/tallerJWT-0.0.1-SNAPSHOT.jar 
```

## 📖 Accessing Swagger UI
Una vez que la aplicación esté en ejecución en el puerto 8080, puedes acceder a la documentación de la API en Swagger a través de la siguiente URL:
```bash
http://localhost:8080/swagger-ui/index.html
```
### 🔐 Credenciales de acceso:
- Usuario: **admin**
- Contraseña: **123**

### 🖥️ Ejecutar `index.html`
1. Registrarse como nuevo usuario.  
2. Iniciar sesión utilizando las credenciales mencionadas anteriormente.

---
## Guía para la implementación de JWT y Spring Security:
🎥 **[Introducción a Spring Security y JWT - Video Explicativo](https://youtu.be/2tf0UY6gV3Y?list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF)**
📄 **[PDF Explicativo](./Documentacion/Investigacion%20JWT-Juan%20Roa%202210086.pdf)** – Documentación de la implementación en formato PDF
