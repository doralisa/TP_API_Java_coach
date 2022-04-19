package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long idUsuario ;

    private String nombreUsuario;

    private String contrasenia;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    private String email;

    private Integer telefono;

}
