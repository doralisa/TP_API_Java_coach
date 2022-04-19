package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EjemploDTO implements Serializable {

    private Long idEjemplo;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "contenidoEjemplo contains invalid characters")
    private String contenidoEjemplo;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9\\s]*$", message = "descripcionEjemplo contains invalid characters")
    private String descripcionEjemplo;

    public Boolean hasNullOrEmptyAttributes() {
        return contenidoEjemplo == null || contenidoEjemplo.trim().isEmpty()
                || descripcionEjemplo == null || descripcionEjemplo.trim().isEmpty();
    }

}
