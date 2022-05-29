package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.PersonaDTO;
import org.blackloop.crud.persistence.dao.PersonaDAO;

import java.util.List;

public class PersonaBl {
    private final PersonaDAO dao = PersonaDAO.getInstance();
    public List<PersonaDTO> getAllPersonas(){
        return dao.findAll();
    }



}
