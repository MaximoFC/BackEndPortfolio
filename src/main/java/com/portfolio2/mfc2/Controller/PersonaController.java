package com.portfolio2.mfc2.Controller;

import com.portfolio2.mfc2.Entity.Persona;
import com.portfolio2.mfc2.Service.ImpPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="https://frontendportfoliomfc-12dd7.web.app, http://localhost:4200")
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired 
    ImpPersonaService imppersonaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return imppersonaService.getPersona();
    }
    
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        imppersonaService.savePersona(persona);
        return "La persona fue creada";
    }
    
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevoDescripcion) {
        Persona persona = imppersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setDescripcion(nuevoDescripcion);

        imppersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/traer/perfil")
    public Persona findPersona() {
        return imppersonaService.findPersona((long) 1);
    }
}
