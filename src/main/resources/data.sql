INSERT IGNORE INTO roles
VALUES
  (1, 'Administrador'),
  (2, 'Almacenista');

INSERT IGNORE INTO usuarios(id_usuario, nombre, correo, contrasena, id_rol, estatus)
       VALUES (1, 'Martin', 'martin@gmail.com', '12345678', 1, 1), (2, 'Jose', 'jose@gmail.com', '12345678', 2, 1);