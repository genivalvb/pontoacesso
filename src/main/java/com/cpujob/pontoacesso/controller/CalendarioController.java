package com.cpujob.pontoacesso.controller;

import com.cpujob.pontoacesso.dto.request.CalendarioDTO;
import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.Calendario;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import com.cpujob.pontoacesso.service.CalendarioService;
import com.cpujob.pontoacesso.service.JornadaTrabalhoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/calendario")
@AllArgsConstructor
public class CalendarioController {
    @Autowired
    private final CalendarioService calendarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid CalendarioDTO calendarioDTO){
        return calendarioService.create(calendarioDTO);
    }

    @GetMapping
    public List<Calendario> getList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{id}")
    public Calendario getById(@RequestParam Long id) throws Exception {
        //return jornadaService.getById(id).orElseThrow(() -> new Exception("calendario not found"));
        return calendarioService.getById(id);
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario){
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@RequestParam Long id) throws Exception {
        return calendarioService.deleteById(id);
    }

}
