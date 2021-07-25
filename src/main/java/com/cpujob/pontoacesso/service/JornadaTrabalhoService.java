package com.cpujob.pontoacesso.service;

import com.cpujob.pontoacesso.dto.mapper.JornadaTrabalhoMapper;
import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import com.cpujob.pontoacesso.repository.JornadaTrabalhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JornadaTrabalhoService {
    @Autowired
    private final JornadaTrabalhoRepository jornadaTrabalhoRepository;

    private final JornadaTrabalhoMapper jornadaTrabalhoMapper = JornadaTrabalhoMapper.INSTANCE;


    public MessageResponseDTO createJornadaTrabalho(JornadaTrabalhoDTO jornadaTrabalhoDTO){
        JornadaTrabalho jornadaTrabalhoToSave = jornadaTrabalhoMapper.toModel(jornadaTrabalhoDTO);
        JornadaTrabalho savedJornadaTrabalho = jornadaTrabalhoRepository.save(jornadaTrabalhoToSave);
        return MessageResponseDTO.builder()
                .message("Jornada de Trabalho criada com ID " + savedJornadaTrabalho.getId() )
                .build();
    }

    public List<JornadaTrabalho> findAll(){
        return jornadaTrabalhoRepository.findAll();
    }

    /*public JornadaTrabalho getById(Long id) {
        return jornadaRepository.getById(id);
    }*/

    public JornadaTrabalho getById(Long id) throws Exception {
        Optional<JornadaTrabalho> optSavedJornada = jornadaTrabalhoRepository.findById(id);
        return optSavedJornada.orElseThrow(() -> new Exception("Jornada não encontrada"));
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public String deleteById(Long id) throws Exception {
        JornadaTrabalho jornadaReturned = this.getById(id);
        String message;
        if(jornadaReturned != null){
            jornadaTrabalhoRepository.delete(jornadaReturned);
            message = "Jornada deletada";
        }else{ message = "Jornada não Encontrada";}
        return message;
    }
}
