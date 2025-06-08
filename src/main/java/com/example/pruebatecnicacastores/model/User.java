package com.example.pruebatecnicacastores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", columnDefinition = "INT(6)")
    private Integer idUsuario;

    @Column(name = "nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(name = "correo", columnDefinition = "VARCHAR(50)")
    private String correo;

    @Column(name = "contrasena", columnDefinition = "VARCHAR(25)")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idRol", foreignKey = @ForeignKey(name = "fk_user_rol"))
    private Rol rol;

    @Column(name = "estatus", columnDefinition = "INT(1)")
    private Integer estatus;

}
