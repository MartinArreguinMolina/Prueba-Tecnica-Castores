package com.example.pruebatecnicacastores.repository.impl;

import com.example.pruebatecnicacastores.model.Producto;
import com.example.pruebatecnicacastores.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> findAll(Integer estatus) {
        if(estatus != 0 && estatus != 1) {
            return productoRepository.findAll();
        }
        return productoRepository.findAllByEstatus(estatus);
    }

    public Producto findById(Integer idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }
}
