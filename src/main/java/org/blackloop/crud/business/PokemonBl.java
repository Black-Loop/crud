package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.PokemonDTO;
import org.blackloop.crud.persistence.dao.PokemonDAO;

import java.util.List;

public class PokemonBl {
    private final PokemonDAO dao = PokemonDAO.getInstance();
    public List<PokemonDTO> getAllPokemones(){
        return dao.findAll();
    }
    public PokemonDTO findPokemonById(int id){
        return dao.findById(id);
    }
    public boolean insertar(PokemonDTO pokemon){
        return dao.insertar(pokemon) != 0;
    }
    public boolean actualizar(PokemonDTO pokemon){
        return dao.actualizar(pokemon) !=0;
    }
    public boolean eliminar(int pokemonId){
        return dao.eliminar(pokemonId) != 0;
    }

}
