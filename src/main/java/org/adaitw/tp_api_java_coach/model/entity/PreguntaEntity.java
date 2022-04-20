package org.adaitw.tp_api_java_coach.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "preguntas", schema = "bot_java_coach")
public class PreguntaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;

    @Column(name = "contenido_pregunta")
    private String contenidoPregunta;

    @ManyToOne
    @JoinColumn(name = "id_concepto")
    private ConceptoEntity idConcepto;

    @OneToMany (mappedBy = "idPregunta")
    private List<RespuestaEntity> respuestas;

    @Override
    public String toString() {
        return "PreguntaEntity{" +
                "idPregunta=" + idPregunta +
                ", contenidoPregunta='" + contenidoPregunta + '\'' +
                ", idConcepto=" + idConcepto +
                ", respuestas=" + respuestas +
                '}';
    }
}
