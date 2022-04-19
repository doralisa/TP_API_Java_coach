package org.adaitw.tp_api_java_coach.model.repository;

import org.adaitw.tp_api_java_coach.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    @Query(value = "SELECT p.* from preguntas p where p.id_concepto = :id", nativeQuery = true)
    List<PreguntaEntity> findByIdconcepto(@Param("id") Long id);

}
