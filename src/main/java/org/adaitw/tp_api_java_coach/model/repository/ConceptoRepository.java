package org.adaitw.tp_api_java_coach.model.repository;

import org.adaitw.tp_api_java_coach.model.entity.ConceptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptoRepository extends JpaRepository<ConceptoEntity, Long> {
}
