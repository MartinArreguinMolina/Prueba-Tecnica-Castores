package com.example.pruebatecnicacastores.repository.impl;

import com.example.pruebatecnicacastores.model.User;
import com.example.pruebatecnicacastores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String correo, String contrasena) {
        return userRepository.getUsersByCorreoAndContrasenaAndEstatus(correo, contrasena, 1).orElse(null);
    }

}
