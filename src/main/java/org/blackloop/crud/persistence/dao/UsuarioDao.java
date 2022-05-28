package org.blackloop.crud.persistence.dao;

import org.blackloop.crud.commons.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

  private static UsuarioDao instance;

  private UsuarioDao() {}

  public static UsuarioDao getInstance() {
    if (instance == null) {
      instance = new UsuarioDao();
    }
    return instance;
  }

  public List<UsuarioDTO> findAll() {
    List<UsuarioDTO> usuariosList = new ArrayList<>();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      String query = "select id, username, password, email from usuario";
      connection = org.blackloop.crud.persistence.Connection.getConnection();
      preparedStatement = connection.prepareStatement(query);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setId(resultSet.getInt("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEmail(resultSet.getString("email"));
        usuariosList.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      org.blackloop.crud.persistence.Connection.close(resultSet);
      org.blackloop.crud.persistence.Connection.close(preparedStatement);
      org.blackloop.crud.persistence.Connection.close(connection);
    }

    return usuariosList;
  }
  
}
