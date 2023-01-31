package com.portfolio2.mfc2.Service;

import com.portfolio2.mfc2.Entity.Persona;
import com.portfolio2.mfc2.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService {

    @Autowired
    IPersonaRepository ipersonaRepository;

    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
}
