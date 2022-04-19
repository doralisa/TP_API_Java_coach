package org.adaitw.tp_api_java_coach.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adaitw.tp_api_java_coach.model.entity.PreguntaEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RespuestaDTO extends CuestionarioDTO implements Serializable {

    private Long idRespuesta;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "contenidoRespuestas contains invalid characters")
    private String contenidoRespuestas;

    @JsonIgnore
    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9\\s]*$", message = "esCorrecta contains invalid characters")
    private Long esCorrecta;

}
