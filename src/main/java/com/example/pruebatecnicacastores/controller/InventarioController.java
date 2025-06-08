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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class InventarioController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/inventario")
    public String inventario(Model model, HttpSession session) {
        List<Producto> productos = productoService.findAll(3);
        model.addAttribute("products", productos);
        model.addAttribute("usuario",session.getAttribute("user"));
        return "inventario";
    }

    @GetMapping("inventario/{estatus}")
    public String inventario(@PathVariable String estatus, Model model, HttpSession session) {
        List<Producto> productos = productoService.findAll(Integer.parseInt(estatus));
        model.addAttribute("products", productos);
        model.addAttribute("usuario",session.getAttribute("user"));
        return "inventario";
    }

    @PostMapping("/inventario/addProduct")
    public ResponseEntity<?> addProduct(@ModelAttribute Producto producto) {
        try {
            Producto p = productoService.save(producto);
            if(p.getIdProducto() == null) {
                return new ResponseEntity<>(new MensajeDTO("Producto no registrado"), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new MensajeDTO("Producto agregado"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MensajeDTO("Ocurrio un error"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/inventario/entrada/{idProducto}/{cantidad}")
    public ResponseEntity<?> entrada(@PathVariable int idProducto, @PathVariable int cantidad, HttpSession session) {
        try {
            Producto producto = productoService.findById(idProducto);
            if(producto == null) {
                return new ResponseEntity<>(new MensajeDTO("Producto no encontrado"), HttpStatus.BAD_REQUEST);
            }
            if(cantidad <= 0) {
                return new ResponseEntity<>(new MensajeDTO("Cantidad invalida"), HttpStatus.BAD_REQUEST);
            }
            producto.setCantidad(producto.getCantidad() + cantidad);
            productoService.save(producto);
            Historico historico = new Historico();
            historico.setFecha(new Date());
            historico.setTipo(1);
            historico.setCantidad(cantidad);
            historico.setUser((User) session.getAttribute("user"));
            historico.setProducto(producto);
            historicoService.save(historico);
            return new ResponseEntity<>(new MensajeDTO("Cantidad agregada"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MensajeDTO("Ocurrio un error"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/inventario/estatus/{idProducto}")
    public ResponseEntity<?> estatus(@PathVariable int idProducto) {
        try {
            Producto producto = productoService.findById(idProducto);
            if(producto == null) {
                return new ResponseEntity<>(new MensajeDTO("Producto no encontrado"), HttpStatus.BAD_REQUEST);
            }
            producto.setEstatus(producto.getEstatus() == 1 ? 0 : 1);
            productoService.save(producto);
            return new ResponseEntity<>(new MensajeDTO("Estatus actualizado"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MensajeDTO("Ocurrio un error"), HttpStatus.BAD_REQUEST);
        }
    }
}
