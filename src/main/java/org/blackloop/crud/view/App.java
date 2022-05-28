package org.blackloop.crud.view;

import org.blackloop.crud.business.UsuarioBl;
import org.blackloop.crud.commons.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    UsuarioBl usuarioBl = new UsuarioBl();
    List<UsuarioDTO> usuarios = usuarioBl.getAllUsuarios();
    for (UsuarioDTO usuario : usuarios) {
      System.out.println(usuario.toString());
    }
  }
}
