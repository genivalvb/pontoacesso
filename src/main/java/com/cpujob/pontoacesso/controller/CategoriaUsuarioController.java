package com.cpujob.pontoacesso.controller;

import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.CategoriaUsuarioDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.CategoriaUsuario;
import com.cpujob.pontoacesso.service.CalendarioService;
import com.cpujob.pontoacesso.service.CategoriaUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria_usuario")
@AllArgsConstructor
public class CategoriaUsuarioController {
    @Autowired
    private final CategoriaUsuarioService categoriaUsuarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid CategoriaUsuarioDTO categoriaUsuarioDTO){
        return categoriaUsuarioService.create(categoriaUsuarioDTO);
    }

    @GetMapping
    public List<CategoriaUsuario> getList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaUsuario getById(@RequestParam Long id) throws Exception {
        //return jornadaService.getById(id).orElseThrow(() -> new Exception("calendario not found"));
        return categoriaUsuarioService.getById(id);
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@RequestParam Long id) throws Exception {
        return categoriaUsuarioService.deleteById(id);
    }

}
