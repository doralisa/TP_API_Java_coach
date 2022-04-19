package org.adaitw.tp_api_java_coach.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "respuestas", schema = "bot_java_coach")
public class RespuestaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;

    @Column(name = "contenido_respuestas", nullable = false)
    private String contenidoRespuestas;

    @JsonIgnore
    @Column(name = "es_correcta", nullable = false)
    private Long esCorrecta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private PreguntaEntity idPregunta;

    @Override
    public String toString() {
        return "RespuestaEntity{" +
                "idRespuesta=" + idRespuesta +
                ", contenidoRespuestas='" + contenidoRespuestas + '\'' +
                ", esCorrecta=" + esCorrecta +
                '}';
    }
}
