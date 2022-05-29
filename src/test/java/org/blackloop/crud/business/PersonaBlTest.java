package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.PersonaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaBlTest {
    PersonaBl personaBl;
    @BeforeEach
    void setup(){
        personaBl = new PersonaBl();
    }
    @Test
    void listarAllPersonas(){
        List<PersonaDTO> lista = personaBl.getAllPersonas();
        for(PersonaDTO persona : lista){
            System.out.println(persona);

        }

    }
    @Test
    void findPersonaById(){
        PersonaDTO persona = personaBl.findPersonaById(2);
        System.out.println(persona);
    }
    @Test
    void insert(){
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Andres");
        persona.setApellido("Carrillo");
        persona.setEdad(31);
        assertTrue(personaBl.insertar(persona), "La insercion fallo");
    }
    @Test
    void actualizar(){
        PersonaDTO persona = personaBl.findPersonaById(2);
        persona.setNombre("Shanks");
        assertTrue(personaBl.insertar(persona), "La actualizacion fallo");
    }
    @Test
    void eliminar(){
        int personaId = 3;
        assertTrue(personaBl.eliminar(personaId),"La eliminacion fallo");
    }
}
