package com.cpujob.pontoacesso.repository;

import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.CategoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaUsuarioRepository extends JpaRepository<CategoriaUsuario, Long> {
}
