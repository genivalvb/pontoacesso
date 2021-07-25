package com.cpujob.pontoacesso.dto.request;

import com.cpujob.pontoacesso.model.TipoData;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class CalendarioDTO {

    private Long id;

    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;
}
