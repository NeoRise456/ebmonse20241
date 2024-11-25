package org.hign.platform.u202110237.ebmonse20241.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
