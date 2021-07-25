package com.cpujob.pontoacesso.dto.mapper;

import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.CategoriaUsuarioDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.CategoriaUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaUsuarioMapper {

    CategoriaUsuarioMapper INSTANCE = Mappers.getMapper(CategoriaUsuarioMapper.class);

    CategoriaUsuario toModel(CategoriaUsuarioDTO categoriaUsuarioDTO);

    CategoriaUsuarioDTO toDTO(CategoriaUsuario categoriaUsuario);
}
