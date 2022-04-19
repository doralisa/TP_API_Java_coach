package org.adaitw.tp_api_java_coach.model.repository;

import org.adaitw.tp_api_java_coach.model.entity.EjemploEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemploRepository extends JpaRepository<EjemploEntity, Long> {
}
