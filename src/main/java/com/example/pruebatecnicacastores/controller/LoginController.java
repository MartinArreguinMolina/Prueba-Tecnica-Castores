package com.example.pruebatecnicacastores.controller;

import com.example.pruebatecnicacastores.model.User;
import com.example.pruebatecnicacastores.repository.impl.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String rootToLogin() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/acceso")
    public String loginPost(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {

        try {
            User user = userService.login(email, password);
            if (user == null) {
                model.addAttribute("mensaje", "credenciales incorrectas");
                return "login";
            }

            session.setAttribute("user", user);
            model.addAttribute("usuario",session.getAttribute("user"));
            model.addAttribute("page", 1);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
