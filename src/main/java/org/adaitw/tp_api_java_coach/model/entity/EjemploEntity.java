package org.adaitw.tp_api_java_coach.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ejemplos", schema = "bot_java_coach")
public class EjemploEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEjemplos;

    @Column(name = "contenido_ejemplo", nullable = false)
    private String contenidoEjemplo;

    @Column(name = "descripcion_ejemplo",nullable = false)
    private String descripcionEjemplo;

    @ManyToOne
    @JoinColumn(name = "id_concepto", nullable = false)
    private ConceptoEntity idConcepto;

    @Override
    public String toString() {
        return "EjemploEntity{" +
                "idEjemplos=" + idEjemplos +
                ", contenidoEjemplo='" + contenidoEjemplo + '\'' +
                ", descripcionEjemplo='" + descripcionEjemplo + '\'' +
                '}';
    }
}
