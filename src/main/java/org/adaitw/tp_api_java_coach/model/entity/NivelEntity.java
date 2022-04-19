package org.adaitw.tp_api_java_coach.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="niveles", schema="bot_java_coach")
public class NivelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel")
    private Long idNivel;

    @Column(name = "nombre_nivel", nullable = false)
    private String nombreNivel;

    @OneToMany (mappedBy = "idNivel")
    private List<CapituloEntity> capitulos;

    @OneToOne (mappedBy = "idNivel")
    private UsuarioEntity usuario;

    @Override
    public String toString() {
        return "NivelEntity{" +
                "idNivel=" + idNivel +
                ", nombreNivel='" + nombreNivel + '\'' +
                '}';
    }
}
