package org.blackloop.crud.commons.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonDTO {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private String status;
    private String naturaleza;
}
