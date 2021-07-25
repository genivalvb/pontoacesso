package com.cpujob.pontoacesso.service;

import com.cpujob.pontoacesso.dto.mapper.BancoHorasMapper;
import com.cpujob.pontoacesso.dto.mapper.CalendarioMapper;
import com.cpujob.pontoacesso.dto.request.BancoHorasDTO;
import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.BancoHoras;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.repository.BancoHorasRepository;
import com.cpujob.pontoacesso.repository.CalendarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalendarioService {
    @Autowired
    private final CalendarioRepository calendarioRepository;

    private final CalendarioMapper calendarioMapper = CalendarioMapper.INSTANCE;


    public MessageResponseDTO create(CalendarioDTO calendarioDTO){
        Calendario calendarioToSave = calendarioMapper.toModel(calendarioDTO);
        Calendario savedCalendario = calendarioRepository.save(calendarioToSave);
        return MessageResponseDTO.builder()
                .message("Calendario criado com ID " + savedCalendario.getId() )
                .build();
    }

    public List<Calendario> findAll(){
        return calendarioRepository.findAll();
    }

    /*public JornadaTrabalho getById(Long id) {
        return jornadaRepository.getById(id);
    }*/

    public Calendario getById(Long id) throws Exception {
        Optional<Calendario> optSavedCalendario = calendarioRepository.findById(id);
        return optSavedCalendario.orElseThrow(() -> new Exception("Calendario não encontrado"));
    }

    public Calendario update(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public String deleteById(Long id) throws Exception {
        Calendario calendarioReturned = this.getById(id);
        String message;
        if(calendarioReturned != null){
            calendarioRepository.delete(calendarioReturned);
            message = "Calendario deletado";
        }else{ message = "Calendario não Encontrada";}
        return message;
    }
}
