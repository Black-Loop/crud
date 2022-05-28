package org.blackloop.crud.commons.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private int id;
    private String username;
    private String password;
    private String email;
}
