package com.cpujob.pontoacesso.controller;

import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.EmpresaDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.Empresa;
import com.cpujob.pontoacesso.service.CalendarioService;
import com.cpujob.pontoacesso.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
@AllArgsConstructor
public class EmpresaController {
    @Autowired
    private final EmpresaService empresaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid EmpresaDTO empresaDTO){
        return empresaService.create(empresaDTO);
    }

    @GetMapping
    public List<Empresa> getList(){
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getById(@RequestParam Long id) throws Exception {
        //return jornadaService.getById(id).orElseThrow(() -> new Exception("calendario not found"));
        return empresaService.getById(id);
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@RequestParam Long id) throws Exception {
        return empresaService.deleteById(id);
    }

}
