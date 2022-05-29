package org.blackloop.crud.persistence.dao;

import org.blackloop.crud.commons.dto.PersonaDTO;


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
                persona.setEdad(resultSet.getInt("dni"));
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


}
