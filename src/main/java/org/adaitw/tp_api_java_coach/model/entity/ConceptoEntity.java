package org.adaitw.tp_api_java_coach.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "conceptos", schema = "bot_java_coach")
public class ConceptoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConcepto;

    @Column(name = "nombre_concepto", nullable = false)
    private String nombreConcepto;

    @Column(name = "numero_concepto", nullable = false)
    private Long numeroConcepto;

    @Column(name = "contenido_concepto", nullable = false)
    private String contenidoConcepto;

    @OneToMany(mappedBy = "idConcepto")
    private Set<PreguntaEntity> preguntas;

    @OneToMany(mappedBy = "idConcepto")
    private Set<EjemploEntity> ejemplos;

    @ManyToOne
    @JoinColumn(name = "id_capitulo", nullable = false)
    private CapituloEntity idCapitulo;

    @Override
    public String toString() {
        return String.format(
                "ConceptoEntity{ idConcepto= %s, nombreConcepto= %s, numeroConcepto= %d, contenidoConcepto= %s}",
                idConcepto, nombreConcepto, numeroConcepto, contenidoConcepto);
    }
}
