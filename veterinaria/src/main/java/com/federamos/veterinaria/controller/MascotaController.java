package com.federamos.veterinaria.controller;

import com.federamos.veterinaria.dto.DuenioMascotaDTO;
import com.federamos.veterinaria.model.Mascota;
import com.federamos.veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    IMascotaService mascotaService;

    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascotaService.getMascotas();
    }

    @GetMapping("/mascotas/traer/{id_mascota}")
    public Mascota findMascota(@PathVariable Long id_mascota){
        return mascotaService.findMascota(id_mascota);
    }

    @GetMapping("/mascotas/traer/dto")
    public List<DuenioMascotaDTO> duenioMascotaDTO(){
        return mascotaService.duenioMascoDTO();
    }

    @GetMapping("/mascotas/caniche")
    public List<Mascota> getCaniche(){
        return mascotaService.getCaniche();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascota){
        mascotaService.saveMascota(mascota);
        return "Mascota creada correctamente";
    }

    @DeleteMapping("/mascotas/borrar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota){
        mascotaService.deleteMascota(id_mascota);
        return "Mascota borrada correctamente";
    }

    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota mascota){
        mascotaService.editMascota(mascota);
        return mascotaService.findMascota(mascota.getId_mascota());
    }

}
