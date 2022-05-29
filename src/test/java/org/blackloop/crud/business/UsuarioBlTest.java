package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.UsuarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioBlTest {

  UsuarioBl usuarioBl;

  @BeforeEach
  void setup() {
    usuarioBl = new UsuarioBl();
  }

  @Test
  void getAllUsuarios() {
    List<UsuarioDTO> usuarios = usuarioBl.getAllUsuarios();
    final int EXPECTED_SIZE = 3;
    assertTrue(usuarios.size() == EXPECTED_SIZE, "Se esperaban " + EXPECTED_SIZE + " usuarios");
  }

  @Test
  void findById() {
    int id = 3;
    UsuarioDTO usuario = usuarioBl.findById(id);
    assertEquals("Borrego", usuario.getUsername(), "Se esperaba Borrego");
  }

  @Test
  void insert() {
    UsuarioDTO usuario = new UsuarioDTO();
    usuario.setUsername("Borrego");
    usuario.setPassword("mitiomegusta");
    usuario.setEmail("tuborreguitomasna@email.com");
    assertTrue(usuarioBl.insert(usuario), "Failed to insert");
  }

  @Test
  void update(){
    UsuarioDTO usuario = usuarioBl.findById(2);
    usuario.setUsername("Vela");
    assertTrue(usuarioBl.update(usuario), "Failed to update");
  }

  @Test
  void delete(){
    int usuarioId = 3;
    assertTrue(usuarioBl.delete(usuarioId), "Failed to delete");
  }

}
