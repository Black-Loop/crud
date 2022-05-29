package org.blackloop.crud.business;

import org.blackloop.crud.commons.dto.PersonaDTO;
import org.blackloop.crud.commons.dto.PokemonDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonBlTest {
    PokemonBl pokemonBl;
    @BeforeEach
    void setup(){
        pokemonBl=new PokemonBl();
    }
    @Test
    void listarAllPokemones(){
        List<PokemonDTO> lista = pokemonBl.getAllPokemones();
        for(PokemonDTO pokemons : lista){
            System.out.println(pokemons);
        }
    }
    @Test
    void findPokemonById() {
        PokemonDTO pokemon = pokemonBl.findPokemonById(3);
        System.out.println(pokemon);
    }
    @Test
    void insertar(){
        PokemonDTO pokemon = new PokemonDTO();
        pokemon.setNombre("Giratina");
        pokemon.setTipo("Dragon/Fantasma");
        pokemon.setNivel(89);
        pokemon.setStatus("Legendario");
        pokemon.setNaturaleza("Picara");
        assertTrue(pokemonBl.insertar(pokemon),"la insercion fallo");
    }
    @Test
    void actualizar(){
        PokemonDTO pokemon=pokemonBl.findPokemonById(1);
        pokemon.setNivel(79);
        assertTrue(pokemonBl.actualizar(pokemon),"La actualizacion fallo");
    }
    @Test
    void eliminar(){
        int pokemonId =2;
        assertTrue(pokemonBl.eliminar(pokemonId),"La eliminacion fallo");
    }

}
