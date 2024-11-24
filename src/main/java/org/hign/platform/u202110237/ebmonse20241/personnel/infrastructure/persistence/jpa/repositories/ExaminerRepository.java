package org.hign.platform.u202110237.ebmonse20241.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}
