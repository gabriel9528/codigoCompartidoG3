package com.relations.ManyToMany.contorller;

import com.relations.ManyToMany.entity.Fiesta;
import com.relations.ManyToMany.entity.Persona;
import com.relations.ManyToMany.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping
    public ResponseEntity<Collection<Persona>> listarPersonas(){
        return new ResponseEntity<>(personaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable("id") Long id){
        Persona persona = personaRepository.findById(id).orElseThrow();
        if(persona!=null){
            return new ResponseEntity<>(personaRepository.findById(id).orElseThrow(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaRepository.save(persona), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable("id") Long id){
        personaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/fiestas")
    public ResponseEntity<Collection<Fiesta>> obtenerFiestasPorIdPersona(@PathVariable("id") Long id){
        Persona persona = personaRepository.findById(id).orElseThrow();
        if(persona!=null){
            return new ResponseEntity<>(persona.getListafiestas(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
