package org.blackloop.crud.persistence.dao;

import org.blackloop.crud.commons.dto.PokemonDTO;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    //Patron Singleton
    private static PokemonDAO instance;
    private PokemonDAO(){}
    public static PokemonDAO getInstance(){
        if(instance == null){
            instance = new PokemonDAO();
        }
        return instance;
    }
    public List<PokemonDTO> findAll(){
        List<PokemonDTO> pokemonesList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        try{
            String consulta="select id,nombre,tipo,nivel,status,naturaleza from pokemon";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                PokemonDTO pokemon = new PokemonDTO();
                pokemon.setId(resultSet.getInt("id"));
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setTipo(resultSet.getString("tipo"));
                pokemon.setNivel(resultSet.getInt("nivel"));
                pokemon.setStatus(resultSet.getString("status"));
                pokemon.setNaturaleza(resultSet.getString("naturaleza"));
                pokemonesList.add(pokemon);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            org.blackloop.crud.persistence.Connection.close(resultSet);
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return pokemonesList;
    }
    public PokemonDTO findById(int id){
        PokemonDTO pokemon = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try{
            String consulta="select id,nombre,tipo,nivel,status,naturaleza from pokemon where id=?";
            connection=org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement=connection.prepareStatement(consulta);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                pokemon=new PokemonDTO();
                pokemon.setId(resultSet.getInt("id"));
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setTipo(resultSet.getString("tipo"));
                pokemon.setNivel(resultSet.getInt("nivel"));
                pokemon.setStatus(resultSet.getString("status"));
                pokemon.setNaturaleza(resultSet.getString("naturaleza"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            org.blackloop.crud.persistence.Connection.close(resultSet);
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return pokemon;

    }
    public int insertar(PokemonDTO pokemon){
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try{
            String consulta = "insert into pokemon(nombre,tipo,nivel,status,naturaleza) values(?,?,?,?,?)";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement=connection.prepareStatement(consulta);
            preparedStatement.setString(1,pokemon.getNombre());
            preparedStatement.setString(2,pokemon.getTipo());
            preparedStatement.setInt(3,pokemon.getNivel());
            preparedStatement.setString(4, pokemon.getStatus());
            preparedStatement.setString(5,pokemon.getNaturaleza());
            rows = preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return rows;
    }
    public int actualizar(PokemonDTO pokemon){
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int rows = 0;
        try{
            String consulta="update pokemon set nombre=?,tipo=?,nivel=?,status=?,naturaleza=? where id=?";
            connection = org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(6,pokemon.getId());
            preparedStatement.setString(1,pokemon.getNombre());
            preparedStatement.setString(2,pokemon.getTipo());
            preparedStatement.setInt(3,pokemon.getNivel());
            preparedStatement.setString(4,pokemon.getStatus());
            preparedStatement.setString(5,pokemon.getNaturaleza());
            rows =preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(connection);
        }
        return rows;
    }
    public int eliminar(int pokemonId){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int rows = 0;
        try {
            String consulta = "delete from pokemon where id=?";
            connection=org.blackloop.crud.persistence.Connection.getConnection();
            preparedStatement =connection.prepareStatement(consulta);
            preparedStatement.setInt(1,pokemonId);
            rows =preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
            org.blackloop.crud.persistence.Connection.close(preparedStatement);
        }
        return rows;
    }

}
