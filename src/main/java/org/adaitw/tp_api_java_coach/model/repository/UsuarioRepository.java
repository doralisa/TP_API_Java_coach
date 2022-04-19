package org.adaitw.tp_api_java_coach.model.repository;

import org.adaitw.tp_api_java_coach.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    //@Query(value = "select u.email from usuarios u where u.nombre_usuario = :nombreUsuario", nativeQuery = true)
    //UsuarioEntity findEmailByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

    UsuarioEntity findByNombreUsuario(String nombreUsuario);

}
