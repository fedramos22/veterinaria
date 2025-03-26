package com.federamos.veterinaria.service;

import com.federamos.veterinaria.dto.DuenioMascotaDTO;
import com.federamos.veterinaria.model.Duenio;
import com.federamos.veterinaria.model.Mascota;
import com.federamos.veterinaria.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    IDuenioRepository duenioRepository;

    @Override
    public List<Duenio> getDuenio() {
        return duenioRepository.findAll();
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepository.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        duenioRepository.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        return duenioRepository.findById(id_duenio).orElse(null);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }
}
