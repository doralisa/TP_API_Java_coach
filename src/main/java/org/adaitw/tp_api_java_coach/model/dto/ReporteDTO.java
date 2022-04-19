package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReporteDTO implements Serializable {

    private Long cantidadCapitulos;

    private Long cantidadConceptos;

    private Long cantidadEjemplos;

    private Long cantidadNiveles;

    private Long cantidadPreguntas;

    private Long cantidadRespuestas;

    private Long cantidadUsuarios;

}
