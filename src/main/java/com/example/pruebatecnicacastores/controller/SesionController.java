package com.example.pruebatecnicacastores.controller;

import com.example.pruebatecnicacastores.model.User;
import com.example.pruebatecnicacastores.repository.impl.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SesionController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        model.addAttribute("usuario",session.getAttribute("user"));
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
