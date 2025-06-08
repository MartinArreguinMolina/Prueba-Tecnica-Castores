package com.example.pruebatecnicacastores.repository.impl;

import com.example.pruebatecnicacastores.model.Historico;
import com.example.pruebatecnicacastores.model.Producto;
import com.example.pruebatecnicacastores.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public void save(Historico historico) {
        historicoRepository.save(historico);
    }


//    TODO: ESTO FUE LO NUEVO AGREGADO PARA EL FILTRADO
    public List<Historico> findAll(Integer estatus) {
        if(estatus != 0 && estatus != 1) {
            return historicoRepository.findAll();
        }
        return historicoRepository.findHistoricoByTipo(estatus);
    }

}
