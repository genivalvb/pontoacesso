package com.cpujob.pontoacesso.service;

import com.cpujob.pontoacesso.dto.mapper.BancoHorasMapper;
import com.cpujob.pontoacesso.dto.mapper.JornadaTrabalhoMapper;
import com.cpujob.pontoacesso.dto.request.BancoHorasDTO;
import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.BancoHoras;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import com.cpujob.pontoacesso.repository.BancoHorasRepository;
import com.cpujob.pontoacesso.repository.JornadaTrabalhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BancoHorasService {
    @Autowired
    private final BancoHorasRepository bancoHorasRepository;

    private final BancoHorasMapper bancoHorasMapper = BancoHorasMapper.INSTANCE;


    public MessageResponseDTO createBancoHoras(BancoHorasDTO bancoHorasDTO){
        BancoHoras bancoHorasToSave = bancoHorasMapper.toModel(bancoHorasDTO);
        BancoHoras savedBancoHoras = bancoHorasRepository.save(bancoHorasToSave);
        return MessageResponseDTO.builder()
                .message("Banco de Horas criado com ID " + savedBancoHoras.getId() )
                .build();
    }

    public List<BancoHoras> findAll(){
        return bancoHorasRepository.findAll();
    }

    /*public JornadaTrabalho getById(Long id) {
        return jornadaRepository.getById(id);
    }*/

    public BancoHoras getById(Long id) throws Exception {
        Optional<BancoHoras> optSavedBancoHoras = bancoHorasRepository.findById(id);
        return optSavedBancoHoras.orElseThrow(() -> new Exception("Banco de Horas não encontrado"));
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public String deleteById(Long id) throws Exception {
        BancoHoras bancoHorasReturned = this.getById(id);
        String message;
        if(bancoHorasReturned != null){
            bancoHorasRepository.delete(bancoHorasReturned);
            message = "Banco de Horas deletado";
        }else{ message = "Banco de Horas não Encontrada";}
        return message;
    }
}
