package com.cpujob.pontoacesso.dto.mapper;

import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalendarioMapper {

    CalendarioMapper INSTANCE = Mappers.getMapper(CalendarioMapper.class);

    Calendario toModel(CalendarioDTO calendarioDTO);

    CalendarioDTO toDTO(Calendario calendario);
}
