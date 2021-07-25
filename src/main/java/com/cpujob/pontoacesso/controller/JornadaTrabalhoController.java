package com.cpujob.pontoacesso.controller;

import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import com.cpujob.pontoacesso.service.JornadaTrabalhoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jornada")
@AllArgsConstructor
public class JornadaTrabalhoController {
    @Autowired
    private final JornadaTrabalhoService jornadaTrabalhoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJornada(@RequestBody @Valid JornadaTrabalhoDTO jornadaTrabalhoDTO){
        return jornadaTrabalhoService.createJornadaTrabalho(jornadaTrabalhoDTO);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping("/{id}")
    public JornadaTrabalho getJornadaById(@RequestParam Long id) throws Exception {
        //return jornadaService.getById(id).orElseThrow(() -> new Exception("jornada not found"));
        return jornadaTrabalhoService.getById(id);
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@RequestParam Long id) throws Exception {
        return jornadaTrabalhoService.deleteById(id);
    }

}
