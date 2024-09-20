package com.app.lab4_20197122_gtics_nube.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "flores")
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflores", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tipo_idtipo", nullable = false)
    private Tipo tipoIdtipo;

    @ColumnDefault("1")
    @Column(name = "is_enable", nullable = false)
    private Byte isEnable;

    @Column(name = "image_url", length = 45)
    private String imageUrl;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ColumnDefault("0")
    @Column(name = "en_carrito", nullable = false)
    private Boolean enCarrito;

    @ColumnDefault("0")
    @Column(name = "es_comprado", nullable = false)
    private Boolean esComprado;
}
