package org.blackloop.crud.view;

import org.blackloop.crud.business.UsuarioBl;
import org.blackloop.crud.commons.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
//    UsuarioBl usuarioBl = new UsuarioBl();
    UsuarioBl usuarioTest = new UsuarioBl();
    int id = 2;
//    List<UsuarioDTO> usuarios = usuarioBl.getAllUsuarios();
//    for (UsuarioDTO usuario : usuarios) {
//      System.out.println(usuario.toString());
//    }
    UsuarioDTO usuario = usuarioTest.findById(id);
    if (usuario != null) {
      System.out.println("Usuario encontrado:");
      System.out.println(usuario);
    } else System.out.println("No se encontro el usuario");
  }
}
