package com.cpujob.pontoacesso.repository;

import com.cpujob.pontoacesso.model.BancoHoras;
import com.cpujob.pontoacesso.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
