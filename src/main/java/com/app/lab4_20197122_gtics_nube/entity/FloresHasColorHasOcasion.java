package com.app.lab4_20197122_gtics_nube.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flores_has_color_has_ocasion")
public class FloresHasColorHasOcasion {
    @EmbeddedId
    private FloresHasColorHasOcasionId id;

    @MapsId("floresIdflores")
    @ManyToOne
    @JoinColumn(name = "flores_idflores", nullable = false)
    private Flor floresIdflores;

    @MapsId("colorIdcolor")
    @ManyToOne
    @JoinColumn(name = "color_idcolor", nullable = false)
    private Color colorIdcolor;

    @MapsId("ocasionIdocasion")
    @ManyToOne
    @JoinColumn(name = "ocasion_idocasion", nullable = false)
    private Ocasion ocasionIdocasion;

}
