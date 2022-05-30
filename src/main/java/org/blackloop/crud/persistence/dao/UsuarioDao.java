package org.blackloop.crud.persistence.dao;

import org.blackloop.crud.commons.dto.UsuarioDTO;

import javax.xml.transform.Result;
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

  public UsuarioDTO findById(int id) {
    UsuarioDTO usuario = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      String query = "select id, username, password, email from usuario where id = ?";
      connection = org.blackloop.crud.persistence.Connection.getConnection();
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        usuario = new UsuarioDTO();
        usuario.setId(resultSet.getInt("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEmail(resultSet.getString("email"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      org.blackloop.crud.persistence.Connection.close(resultSet);
      org.blackloop.crud.persistence.Connection.close(preparedStatement);
      org.blackloop.crud.persistence.Connection.close(connection);
    }
    return usuario;
  }

  public int insert(UsuarioDTO usuario, int idPersona) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int rows = 0;

    try {
      String query =
          "insert into usuario(username, password, email, id_persona) values (?, ?, ?, ?)";
      connection = org.blackloop.crud.persistence.Connection.getConnection();
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, usuario.getUsername());
      preparedStatement.setString(2, usuario.getPassword());
      preparedStatement.setString(3, usuario.getEmail());
      preparedStatement.setInt(4, idPersona);
      rows = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      org.blackloop.crud.persistence.Connection.close(preparedStatement);
      org.blackloop.crud.persistence.Connection.close(connection);
    }
    return rows;
  }

  public int update(UsuarioDTO usuario) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int rows = 0;

    try {
      String query = "update usuario set username = ?, password = ?, email = ? where id = ?";
      connection = org.blackloop.crud.persistence.Connection.getConnection();
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(4, usuario.getId());
      preparedStatement.setString(1, usuario.getUsername());
      preparedStatement.setString(2, usuario.getPassword());
      preparedStatement.setString(3, usuario.getEmail());

      rows = preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      org.blackloop.crud.persistence.Connection.close(preparedStatement);
      org.blackloop.crud.persistence.Connection.close(connection);
    }
    return rows;
  }

  public int delete(int usuarioId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int rows = 0;

    try {
      String query = "delete from usuario where id = ?";
      connection = org.blackloop.crud.persistence.Connection.getConnection();
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, usuarioId);
      rows = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      org.blackloop.crud.persistence.Connection.close(preparedStatement);
      org.blackloop.crud.persistence.Connection.close(connection);
    }
    return rows;
  }
}
