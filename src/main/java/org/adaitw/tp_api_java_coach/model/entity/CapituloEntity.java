package org.adaitw.tp_api_java_coach.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="capitulos", schema="bot_java_coach")
public class CapituloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCapitulo;

    @Column(name = "nombre_capitulo", nullable = false)
    private String nombreCapitulo;;

    @Column(name = "numero_capitulo", nullable = false)
    private Long numeroCapitulo;

    @OneToMany (mappedBy = "idCapitulo")
    private List<ConceptoEntity> conceptos;

    @ManyToOne
    @JoinColumn(name = "id_nivel", nullable = false)
    private NivelEntity idNivel;

    @Override
    public String toString() {
        return "CapituloEntity{" +
                "idCapitulo=" + idCapitulo +
                ", nombreCapitulo='" + nombreCapitulo + '\'' +
                ", numeroCapitulo=" + numeroCapitulo +
                '}';
    }
}
