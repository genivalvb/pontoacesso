package com.cpujob.pontoacesso.service;

import com.cpujob.pontoacesso.dto.mapper.CalendarioMapper;
import com.cpujob.pontoacesso.dto.mapper.EmpresaMapper;
import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.EmpresaDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.Empresa;
import com.cpujob.pontoacesso.repository.CalendarioRepository;
import com.cpujob.pontoacesso.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaService {
    @Autowired
    private final EmpresaRepository empresaRepository;

    private final EmpresaMapper empresaMapper = EmpresaMapper.INSTANCE;


    public MessageResponseDTO create(EmpresaDTO empresaDTO){
        Empresa empresaToSave = empresaMapper.toModel(empresaDTO);
        Empresa savedEmpresa = empresaRepository.save(empresaToSave);
        return MessageResponseDTO.builder()
                .message("Empresa criada com ID " + savedEmpresa.getId() )
                .build();
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    /*public JornadaTrabalho getById(Long id) {
        return jornadaRepository.getById(id);
    }*/

    public Empresa getById(Long id) throws Exception {
        Optional<Empresa> optSavedEmpresa = empresaRepository.findById(id);
        return optSavedEmpresa.orElseThrow(() -> new Exception("Empresa não encontrada"));
    }

    public Empresa update(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public String deleteById(Long id) throws Exception {
        Empresa empresaReturned = this.getById(id);
        String message;
        if(empresaReturned != null){
            empresaRepository.delete(empresaReturned);
            message = "Empresa deletada";
        }else{ message = "Empresa não Encontrada";}
        return message;
    }
}
