package org.blackloop.crud.persistence.dao;

import org.blackloop.crud.commons.dto.PersonaDTO;
import org.blackloop.crud.commons.dto.UsuarioDTO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    //Patron Singleton
    private static PersonaDAO instance;

    private PersonaDAO() {
    }

    public static PersonaDAO getInstance() {
        if (instance == null) {
            instance = new PersonaDAO();
        }
        return instance;
    }

    public List<PersonaDTO> findAll() {
        List<PersonaDTO> personas = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String consulta = "select id,nombre,apellido,edad from persona";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                PersonaDTO persona = new PersonaDTO();
                persona.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setEdad(resultSet.getInt("edad"));
                personas.add(persona);
            }
        }catch(SQLException e){
           e.printStackTrace();

        }finally {
            org.blackloop.crud.persistence.Connection.close(resultSet);
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }

        return personas;
    }
    public PersonaDTO findById(int id){
        PersonaDTO persona=null;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String consulta = "select id,nombre,apellido,edad from persona where id= ?";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                persona = new PersonaDTO();
                persona.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setEdad(resultSet.getInt("edad"));
            }
        }catch(SQLException e){
            e.printStackTrace();

        }finally{
            org.blackloop.crud.persistence.Connection.close(resultSet);
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }

        return persona;
    }
    public int insertar(PersonaDTO persona){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try{
            String consulta = "insert into persona(nombre, apellido, edad) values (?, ?, ?)";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setInt(3, persona.getEdad());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return rows;
    }
    public int actualizar(PersonaDTO persona){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try{
            String query = "update persona set nombre = ?, apellido = ?, edad = ? where id = ?";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(4, persona.getId());
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setInt(3, persona.getEdad());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return rows;
    }
    public int eliminar(int personaId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try{
            String consulta ="delete from persona  where id = ?";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, personaId);
            rows = preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();

        }finally {
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return rows;
    }


}
