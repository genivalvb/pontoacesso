package com.cpujob.pontoacesso.dto.request;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BancoHorasDTO {

    public class BancoHorasId implements Serializable {
        private Long idBancoHoras;
        private Long idMovimentacao;
        private Long idUsuario;
    }
    private static final long serialVersionUID = 1L;

    private BancoHorasId id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
