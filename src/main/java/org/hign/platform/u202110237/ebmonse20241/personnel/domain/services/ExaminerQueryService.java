package org.hign.platform.u202110237.ebmonse20241.personnel.domain.services;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByIdQuery;

import java.util.Optional;

/**
 * Service for handling examiner queries
 * @author Juan Astonitas
 */
public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByIdQuery query);
}
