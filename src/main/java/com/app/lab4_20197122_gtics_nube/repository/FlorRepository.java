package com.app.lab4_20197122_gtics_nube.repository;

import com.app.lab4_20197122_gtics_nube.entity.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Integer> {
}
