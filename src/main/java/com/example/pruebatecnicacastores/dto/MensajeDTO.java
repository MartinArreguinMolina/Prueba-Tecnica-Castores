package com.example.pruebatecnicacastores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeDTO implements Serializable {

    private String mensaje;
}
