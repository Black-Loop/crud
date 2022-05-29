package org.blackloop.crud.commons.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PokemonDTO {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private String status;
    private String naturaleza;
}
