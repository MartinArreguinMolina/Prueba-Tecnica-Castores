package com.example.pruebatecnicacastores.repository;

import com.example.pruebatecnicacastores.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

   Optional<User> getUsersByCorreoAndContrasenaAndEstatus(String correo, String contrasena, Integer estatus);
}
