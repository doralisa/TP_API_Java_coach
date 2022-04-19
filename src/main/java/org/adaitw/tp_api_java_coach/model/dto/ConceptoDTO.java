package org.adaitw.tp_api_java_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adaitw.tp_api_java_coach.model.entity.CapituloEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConceptoDTO implements Serializable {

    private Long idConcepto;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "nombreConcepto contains invalid characters")
    private String nombreConcepto;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9\\s]*$", message = "numeroConcepto contains invalid characters")
    private Long numeroConcepto;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "contenidoConcepto contains invalid characters")
    private String contenidoConcepto;

    private CapituloDTO idCapitulo = getIdCapitulo();

    @Override
    public String toString() {
        return "ConceptoDTO{" +
                "idConcepto=" + idConcepto +
                ", nombreConcepto='" + nombreConcepto + '\'' +
                ", numeroConcepto=" + numeroConcepto +
                ", contenidoConcepto='" + contenidoConcepto + '\'' +
                '}';
    }

    public Boolean hasNullOrEmptyAttributes() {
        return nombreConcepto == null || nombreConcepto.trim().isEmpty()
                || numeroConcepto == null
                || contenidoConcepto == null || contenidoConcepto.trim().isEmpty();
    }
}
