package com.cpujob.pontoacesso.dto.mapper;

import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JornadaTrabalhoMapper {

    JornadaTrabalhoMapper INSTANCE = Mappers.getMapper(JornadaTrabalhoMapper.class);

    JornadaTrabalho toModel(JornadaTrabalhoDTO jornadaTrabalhoDTO);

    JornadaTrabalhoDTO toDTO(JornadaTrabalho jornadaTrabalho);
}
