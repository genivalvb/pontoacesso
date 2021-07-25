package com.cpujob.pontoacesso.dto.request;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JornadaTrabalhoDTO {
    private Long id;
    @NotEmpty
    @Size(min= 10, max=200)
    private String descricao;
}
