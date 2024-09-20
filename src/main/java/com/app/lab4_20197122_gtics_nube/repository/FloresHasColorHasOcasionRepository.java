package com.app.lab4_20197122_gtics_nube.repository;

import com.app.lab4_20197122_gtics_nube.entity.FloresHasColorHasOcasion;
import com.app.lab4_20197122_gtics_nube.entity.FloresHasColorHasOcasionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloresHasColorHasOcasionRepository extends JpaRepository<FloresHasColorHasOcasion, FloresHasColorHasOcasionId> {
    List<FloresHasColorHasOcasion> findAllByColorIdcolor_Id(Integer colorId);
    List<FloresHasColorHasOcasion> findAllByOcasionIdocasion_Id(Integer ocasionId);
    List<FloresHasColorHasOcasion> findAllByFloresIdflores_TipoIdtipo_Id(Integer tipoId);

    @Query("SELECT f FROM FloresHasColorHasOcasion f WHERE " +
            "(:colorId IS NULL OR f.colorIdcolor.id = :colorId) AND " +
            "(:tipoId IS NULL OR f.floresIdflores.tipoIdtipo.id = :tipoId) AND " +
            "(:ocasionId IS NULL OR f.ocasionIdocasion.id = :ocasionId)")
    List<FloresHasColorHasOcasion> findByFilters(@Param("colorId") Integer colorId,
                                                 @Param("tipoId") Integer tipoId,
                                                 @Param("ocasionId") Integer ocasionId);
}
