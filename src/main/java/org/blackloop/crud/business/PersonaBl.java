package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.PersonaDTO;
import org.blackloop.crud.persistence.dao.PersonaDAO;

import java.util.List;

public class PersonaBl {
    private final PersonaDAO dao = PersonaDAO.getInstance();
    public List<PersonaDTO> getAllPersonas(){
        return dao.findAll();
    }
    public PersonaDTO findPersonaById(int id){
        return dao.findById(id);
    }
    public boolean insertar(PersonaDTO persona){
        return dao.insertar(persona) != 0;
    }
    public boolean actualizar(PersonaDTO persona){
        return dao.actualizar(persona) != 0;
    }
    public boolean eliminar(int personaId){
        return dao.eliminar(personaId) != 0;
    }
}
