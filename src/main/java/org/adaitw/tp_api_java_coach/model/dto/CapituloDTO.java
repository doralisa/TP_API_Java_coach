package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adaitw.tp_api_java_coach.model.entity.NivelEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapituloDTO {

    private Long idCapitulo;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "nombreCapitulo contains invalid characters")
    private String nombreCapitulo;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9\\s]*$", message = "numeroCapitulo contains invalid characters")
    private Long numeroCapitulo;

}
