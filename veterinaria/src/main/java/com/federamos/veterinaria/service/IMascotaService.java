package com.federamos.veterinaria.service;

import com.federamos.veterinaria.dto.DuenioMascotaDTO;
import com.federamos.veterinaria.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMascotaService {
    List<Mascota> getMascotas();
    public void saveMascota(Mascota mascota);
    public void deleteMascota(Long id_mascota);
    public Mascota findMascota(Long id_mascota);
    public void editMascota(Mascota mascota);
    public List<DuenioMascotaDTO> duenioMascoDTO();
    public List<Mascota> getCaniche();
}
