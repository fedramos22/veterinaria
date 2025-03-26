package com.federamos.veterinaria.controller;

import com.federamos.veterinaria.model.Duenio;
import com.federamos.veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenioController {

    @Autowired
    private IDuenioService duenioService;

    @GetMapping("/duenio/traer")
    public List<Duenio> getDuenio(){
        return duenioService.getDuenio();
    }

    @GetMapping("/duenio/traer/{id_duenio}")
    public Duenio findDuenio(@PathVariable Long id_duenio){
        return duenioService.findDuenio(id_duenio);
    }

    @PostMapping("/duenio/crear")
    public String saveDuenio(@RequestBody Duenio duenio){
        duenioService.saveDuenio(duenio);
        return "Dueño creado correctamente";
    }

    @DeleteMapping("/duenio/borrar/{id_duenio}")
    public String deleteDuenio(@PathVariable Long id_duenio){
        duenioService.deleteDuenio(id_duenio);
        return "Dueño borrado correctamente";
    }

    @PutMapping("/duenio/editar")
    public Duenio editDuenio(@RequestBody Duenio duenio){
        duenioService.editDuenio(duenio);
        return duenioService.findDuenio(duenio.getId_duenio());
    }
}
