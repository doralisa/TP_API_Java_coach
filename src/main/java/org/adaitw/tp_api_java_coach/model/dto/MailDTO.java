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
public class MailDTO implements Serializable {

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "nombreUsuario contains invalid characters")
    private String asunto;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "nombreUsuario contains invalid characters")
    private String de;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "email contains invalid characters")
    private String para;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "contenidoConcepto contains invalid characters")
    private String contenido;

    @Override
    public String toString() {
        return "MailDTO{" +
                "asunto=" + asunto + '\'' +
                ", de=" + de + '\'' +
                ", para=" + para + '\'' +
                ", contenido=" + contenido + '\'' +
                '}';
    }

    public Boolean hasNullOrEmptyAttributes() {
        return asunto == null || asunto.trim().isEmpty()
                || de == null || de.trim().isEmpty()
                || para == null || para.trim().isEmpty()
                || contenido == null || contenido.trim().isEmpty();
    }

}
