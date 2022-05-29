package org.blackloop.crud.commons.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
