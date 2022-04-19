package org.adaitw.tp_api_java_coach.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuestionarioDTO implements Serializable {

    @JsonIgnore
    private Long idPregunta;

    private String contenidoPregunta;

    private Long idConcepto;

    private List<RespuestaDTO> respuestas;

    @Override
    public String toString() {
        return "CuestionarioDTO{" +
                "idPregunta=" + idPregunta +
                ", contenidoPregunta='" + contenidoPregunta + '\'' +
                ", idConcepto=" + idConcepto +
                ", respuestas=" + respuestas +
                '}';
    }

    public Boolean hasNullOrEmptyAttributes() {
        return contenidoPregunta == null || contenidoPregunta.trim().isEmpty()
                || respuestas == null;

    }

}
