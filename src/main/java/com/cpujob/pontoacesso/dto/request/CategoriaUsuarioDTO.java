package com.cpujob.pontoacesso.dto.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class CategoriaUsuarioDTO {

    private Long id;
    private String descricao;
}
