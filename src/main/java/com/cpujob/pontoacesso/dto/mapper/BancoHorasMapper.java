package com.cpujob.pontoacesso.dto.mapper;

import com.cpujob.pontoacesso.dto.request.BancoHorasDTO;
import com.cpujob.pontoacesso.model.BancoHoras;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BancoHorasMapper {

    BancoHorasMapper INSTANCE = Mappers.getMapper(BancoHorasMapper.class);

    @Mapping(target="id", ignore=true)
    BancoHorasDTO toDTO(BancoHoras source);
    @Mapping(target="id", ignore=true)
    BancoHoras toModel(BancoHorasDTO source);
    /*
    @Mapping(source="id", target="id")
    BancoHoras toModel(BancoHorasDTO bancoHorasDTO);
    @Mapping(source="id", target="id")
    BancoHorasDTO toDTO(BancoHoras bancoHoras);
    */

}
