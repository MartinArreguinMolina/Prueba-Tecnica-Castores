
# Prueba técnica Castores

---

## Herramientas y tecnologías a utilizar

- **Java JDK 17 y SprintBoot** con Maven
- **IntelliJ IDEA Ultimate Edition 2024.3.1.1** (puede funcionar con cualquier versión)
- **DBMS: XAMPP 8.2.12** (puede funcionar con cualquier versión de XAMPP)

---

## Pasos para correr la aplicación

1. **Instalar las herramientas necesarias**
    - Descargar e instalar IntelliJ IDEA  
      [Ir a Instalación](https://www.jetbrains.com/es-es/idea/download/?section=windows)
    - Descargar e instalar XAMPP  
      [Ir a Instalación](https://www.apachefriends.org/es/download.html)
    - Descargar e instalar el navegador de tu preferencia (ejemplos):
        - [Google Chrome](https://www.google.com/intl/es_us/chrome/)
        - [Firefox](https://www.mozilla.org/es-MX/firefox/new/)

2. **Abrir IntelliJ IDEA**
    1. Seleccionar **Clone repository** al iniciar IntelliJ IDEA
    2. En el menú **Version control**, elegir **Git**
    3. En **URL**, pegar:
       ```
       https://github.com/MartinArreguinMolina/Prueba-Tecnica-Castores
       ```  
    4. En **Directory**, indicar la carpeta destino para clonar
    5. Hacer clic en **Clone**

3. **Correr la aplicación web Java con Spring Boot**

    - Abrir XAMPP e iniciar Apache y MySQL.

   **IMPORTANTE**

   > Para que la aplicación funcione correctamente, debes importar la base de datos que se encuentra en la carpeta **scripts**.  
   > Para ello:
   > 1. Abrir XAMPP y hacer clic en **Admin** del módulo **MySQL**.
   > 2. Dentro de **phpMyAdmin**, importar el script mencionado anteriormente.

    - Ejecutar el proyecto desde **IntelliJ IDEA**.
    - Abrir en el navegador:
      ```shell
      http://localhost:8000
      ```


4. **Tu aplicación de inventario estará corriendo perfectamente**
    1. Puedes ingresar la siguiente informacion de  los roles en el login
        - Administrador
            Correo Electronico: martin@gmail.com
            contraseña: 12345678
        - Almacenista
            Correo Electronico: jose@gmail.com
            Contraseña: 12345678
---