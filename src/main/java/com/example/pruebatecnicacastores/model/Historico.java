package com.example.pruebatecnicacastores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "historicos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorico")
    private Integer idHistorico;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "fk_historico_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProducto", foreignKey = @ForeignKey(name = "fk_historico_producto"))
    private Producto producto;
}
