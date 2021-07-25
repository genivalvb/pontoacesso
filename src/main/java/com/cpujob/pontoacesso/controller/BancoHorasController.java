package com.cpujob.pontoacesso.controller;

import com.cpujob.pontoacesso.dto.request.BancoHorasDTO;
import com.cpujob.pontoacesso.dto.request.JornadaTrabalhoDTO;
import com.cpujob.pontoacesso.dto.response.MessageResponseDTO;
import com.cpujob.pontoacesso.model.BancoHoras;
import com.cpujob.pontoacesso.model.JornadaTrabalho;
import com.cpujob.pontoacesso.service.BancoHorasService;
import com.cpujob.pontoacesso.service.JornadaTrabalhoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bancohoras")
@AllArgsConstructor
public class BancoHorasController {
    @Autowired
    private final BancoHorasService bancoHorasService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createBancoHoras(@RequestBody @Valid BancoHorasDTO bancoHorasDTO){
        return bancoHorasService.createBancoHoras(bancoHorasDTO);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{id}")
    public BancoHoras getBancoHorasById(@RequestParam Long id) throws Exception {
        //return jornadaService.getById(id).orElseThrow(() -> new Exception("jornada not found"));
        return bancoHorasService.getById(id);
    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@RequestParam Long id) throws Exception {
        return bancoHorasService.deleteById(id);
    }

}
