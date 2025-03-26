package com.federamos.veterinaria.service;

import com.federamos.veterinaria.dto.DuenioMascotaDTO;
import com.federamos.veterinaria.model.Duenio;

import java.util.List;

public interface IDuenioService {
    List<Duenio> getDuenio();
    public void saveDuenio(Duenio duenio);
    public void deleteDuenio(Long id_duenio);
    public Duenio findDuenio(Long id_duenio);
    public void editDuenio(Duenio duenio);
}
