package com.example.pruebatecnicacastores.repository;

import com.example.pruebatecnicacastores.model.Historico;
import com.example.pruebatecnicacastores.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
    List<Historico> findHistoricoByTipo(Integer tipo);
}