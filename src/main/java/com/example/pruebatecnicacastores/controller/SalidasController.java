package com.example.pruebatecnicacastores.controller;

import com.example.pruebatecnicacastores.dto.MensajeDTO;
import com.example.pruebatecnicacastores.model.Historico;
import com.example.pruebatecnicacastores.model.Producto;
import com.example.pruebatecnicacastores.model.User;
import com.example.pruebatecnicacastores.repository.impl.HistoricoService;
import com.example.pruebatecnicacastores.repository.impl.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller

public class SalidasController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/salidas")
    public String salidas(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if ("Administrador".equals(user.getRol().getNombre())) {
            return "redirect:/index";
        }

        model.addAttribute("page", 3);
        List<Producto> productos = productoService.findAll(1);
        model.addAttribute("products", productos);
        model.addAttribute("usuario",session.getAttribute("user"));
        return "salidas";
    }

    @PostMapping("/salidas/salida/{idProducto}/{cantidad}")
    public ResponseEntity<?> salida(@PathVariable int idProducto, @PathVariable int cantidad, HttpSession session) {
        try {
            Producto producto = productoService.findById(idProducto);
            if(producto == null) {
                return new ResponseEntity<>(new MensajeDTO("Producto no encontrado"), HttpStatus.BAD_REQUEST);
            }
            if(cantidad <= 0) {
                return new ResponseEntity<>(new MensajeDTO("Cantidad invalida"), HttpStatus.BAD_REQUEST);
            }
            if(cantidad > producto.getCantidad()) {
                return new ResponseEntity<>(new MensajeDTO("No se puede sacar una cantidad mayor a la del inventario"), HttpStatus.BAD_REQUEST);
            }
            producto.setCantidad(producto.getCantidad() - cantidad);
            productoService.save(producto);
            Historico historico = new Historico();
            historico.setFecha(new Date());
            historico.setTipo(0);
            historico.setCantidad(cantidad);
            historico.setUser((User) session.getAttribute("user"));
            historico.setProducto(producto);
            historicoService.save(historico);
            return new ResponseEntity<>(new MensajeDTO("Salida Exitosa"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MensajeDTO("Ocurrio un error"), HttpStatus.BAD_REQUEST);
        }
    }
}
