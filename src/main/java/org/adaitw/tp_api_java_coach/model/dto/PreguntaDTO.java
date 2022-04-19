package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adaitw.tp_api_java_coach.model.entity.CapituloEntity;
import org.adaitw.tp_api_java_coach.model.entity.ConceptoEntity;
import org.adaitw.tp_api_java_coach.model.entity.RespuestaEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PreguntaDTO extends CuestionarioDTO implements Serializable {

    private Long idPregunta;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "contenidoPregunta contains invalid characters")
    private String contenidoPregunta;

}
