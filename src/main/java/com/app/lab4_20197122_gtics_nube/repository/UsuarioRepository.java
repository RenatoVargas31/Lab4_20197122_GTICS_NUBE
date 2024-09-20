package com.app.lab4_20197122_gtics_nube.repository;

import com.app.lab4_20197122_gtics_nube.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
