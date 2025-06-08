package com.example.pruebatecnicacastores.repository;

import com.example.pruebatecnicacastores.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    List<Producto> findAllByEstatus(Integer estatus);
}
