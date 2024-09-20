package com.app.lab4_20197122_gtics_nube.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class FloresHasColorHasOcasionId implements Serializable {

    @Column(name = "flores_idflores", nullable = false)
    private Integer floresIdflores;

    @Column(name = "color_idcolor", nullable = false)
    private Integer colorIdcolor;

    @Column(name = "ocasion_idocasion", nullable = false)
    private Integer ocasionIdocasion;

}