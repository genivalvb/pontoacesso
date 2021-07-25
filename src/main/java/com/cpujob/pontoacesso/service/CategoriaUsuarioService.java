package com.cpujob.pontoacesso.service;

import com.cpujob.pontoacesso.dto.mapper.CalendarioMapper;
import com.cpujob.pontoacesso.dto.mapper.CategoriaUsuarioMapper;
import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.CategoriaUsuarioDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.CategoriaUsuario;
import com.cpujob.pontoacesso.repository.CalendarioRepository;
import com.cpujob.pontoacesso.repository.CategoriaUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaUsuarioService {
    @Autowired
    private final CategoriaUsuarioRepository categoriaUsuarioRepository;

    private final CategoriaUsuarioMapper categoriaUsuarioMapper = CategoriaUsuarioMapper.INSTANCE;


    public MessageResponseDTO create(CategoriaUsuarioDTO categoriaUsuarioDTO){
        CategoriaUsuario categoriaUsuarioToSave = categoriaUsuarioMapper.toModel(categoriaUsuarioDTO);
        CategoriaUsuario savedCategoriaUsuario = categoriaUsuarioRepository.save(categoriaUsuarioToSave);
        return MessageResponseDTO.builder()
                .message("Categoria Usuario criado com ID " + savedCategoriaUsuario.getId() )
                .build();
    }

    public List<CategoriaUsuario> findAll(){
        return categoriaUsuarioRepository.findAll();
    }

    /*public JornadaTrabalho getById(Long id) {
        return jornadaRepository.getById(id);
    }*/

    public CategoriaUsuario getById(Long id) throws Exception {
        Optional<CategoriaUsuario> optSavedCategoriaUsuario = categoriaUsuarioRepository.findById(id);
        return optSavedCategoriaUsuario.orElseThrow(() -> new Exception("Categoria de Usuário não encontrado"));
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public String deleteById(Long id) throws Exception {
        CategoriaUsuario categoriaUsuarioReturned = this.getById(id);
        String message;
        if(categoriaUsuarioReturned != null){
            categoriaUsuarioRepository.delete(categoriaUsuarioReturned);
            message = "Categoria de usuário deletada";
        }else{ message = "Categoria de Usuario não Encontrada";}
        return message;
    }
}
