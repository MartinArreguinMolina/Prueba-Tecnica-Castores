package com.example.pruebatecnicacastores.controller;

import com.example.pruebatecnicacastores.model.Historico;
import com.example.pruebatecnicacastores.model.Producto;
import com.example.pruebatecnicacastores.model.User;
import com.example.pruebatecnicacastores.repository.impl.HistoricoService;
import com.example.pruebatecnicacastores.repository.impl.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/historico")
    public String historico(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if ("Almacenista".equals(user.getRol().getNombre())) {
            return "redirect:/index";
        }

        List<Historico> historicos = historicoService.findAll(3);
        model.addAttribute("historicos", historicos);
        model.addAttribute("usuario",session.getAttribute("user"));
        return "historico";
    }

//    TODO: ESTO FUE LO NUEVO AGREGADO
    @GetMapping("historico/{tipo}")
    public String historico(@PathVariable String tipo, Model model, HttpSession session) {
        List<Historico> historicos = historicoService.findAll(Integer.parseInt(tipo));
        model.addAttribute("historicos", historicos);
        model.addAttribute("usuario",session.getAttribute("user"));
        return "historico";
    }

}
