package org.blackloop.crud.business;

import org.blackloop.crud.persistence.dao.UsuarioDao;
import org.blackloop.crud.commons.dto.UsuarioDTO;

import java.util.List;

public class UsuarioBl {
  private final UsuarioDao dao = UsuarioDao.getInstance();

  public List<UsuarioDTO> getAllUsuarios() {
    return dao.findAll();
  }

  public UsuarioDTO findById(int id) {
    return dao.findById(id);
  }

  public boolean insert(UsuarioDTO usuario, int idPersona) {
    return dao.insert(usuario, idPersona) != 0;
  }

  public boolean update(UsuarioDTO usuario) {
    return dao.update(usuario) != 0;
  }

  public boolean delete(int usuarioId) {
    return dao.delete(usuarioId) != 0;
  }
}
