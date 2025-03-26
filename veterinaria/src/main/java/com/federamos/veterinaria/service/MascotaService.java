package com.federamos.veterinaria.service;

import com.federamos.veterinaria.dto.DuenioMascotaDTO;
import com.federamos.veterinaria.model.Mascota;
import com.federamos.veterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaRepository.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return mascotaRepository.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Mascota mascota) {
        this.saveMascota(mascota);
    }

    @Override
    public List<DuenioMascotaDTO> duenioMascoDTO() {

        List<Mascota> listaMascota = this.getMascotas();
        List<DuenioMascotaDTO> listaDuenioMasco = new ArrayList<DuenioMascotaDTO>();
        DuenioMascotaDTO duenio_masco = new DuenioMascotaDTO();

        for (Mascota masco : listaMascota){

            System.out.println(masco.getNombre_mascota());
            duenio_masco.setNombre_duenio(masco.getDuenio().getNombre_duenio());
            duenio_masco.setNombre_mascota(masco.getNombre_mascota());
            duenio_masco.setApellido_duenio(masco.getDuenio().getApellido_duenio());
            duenio_masco.setRaza(masco.getRaza());
            duenio_masco.setEspecie(masco.getEspecie());

            listaDuenioMasco.add(duenio_masco);
            duenio_masco = new DuenioMascotaDTO();
        }


        return listaDuenioMasco;
    }

    @Override
    public List<Mascota> getCaniche() {
        String nombreRaza = "caniche";
        String textoComparar;

        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for (Mascota masco : listaMascotas){
            textoComparar = masco.getRaza();
            boolean esCaniche = textoComparar.equals(nombreRaza);
            if (esCaniche == true){
                listaCaniches.add(masco);
            }

        }

        return listaCaniches;
    }

}
