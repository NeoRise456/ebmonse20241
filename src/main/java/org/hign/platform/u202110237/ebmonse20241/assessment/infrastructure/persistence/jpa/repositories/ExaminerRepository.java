package org.hign.platform.u202110237.ebmonse20241.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

}
