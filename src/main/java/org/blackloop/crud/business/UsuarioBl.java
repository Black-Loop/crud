package org.blackloop.crud.business;

import org.blackloop.crud.persistence.dao.UsuarioDao;
import org.blackloop.crud.commons.dto.UsuarioDTO;

import java.util.List;

public class UsuarioBl {
    private final UsuarioDao dao = UsuarioDao.getInstance();

    public List<UsuarioDTO> getAllUsuarios(){
        return dao.findAll();
    }
}
