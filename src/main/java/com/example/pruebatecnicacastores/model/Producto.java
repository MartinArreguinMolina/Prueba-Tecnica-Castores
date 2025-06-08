package com.example.pruebatecnicacastores.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto", columnDefinition = "INT(6)")
    private Integer idProducto;

    @Column(name = "nombre", columnDefinition = "VARCHAR(60)")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad", columnDefinition = "INT DEFAULT 0")
    private Integer cantidad;

    @Column(name = "estatus", columnDefinition = "INT(1)")
    private Integer estatus;

}
