package com.cpujob.pontoacesso.repository;

import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
