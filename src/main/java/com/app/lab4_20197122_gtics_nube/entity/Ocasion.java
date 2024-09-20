package com.app.lab4_20197122_gtics_nube.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ocasion")
public class Ocasion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idocasion", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

}
