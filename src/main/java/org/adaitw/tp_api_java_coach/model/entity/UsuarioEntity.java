package org.adaitw.tp_api_java_coach.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuarios", schema = "bot_java_coach")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario ;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @JsonIgnore
    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Basic
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private Integer telefono;

    @OneToOne
    @JoinColumn(name = "id_nivel")
    private NivelEntity idNivel;

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
