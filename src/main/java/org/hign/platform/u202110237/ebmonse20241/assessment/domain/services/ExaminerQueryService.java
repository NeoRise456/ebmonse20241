package org.hign.platform.u202110237.ebmonse20241.assessment.domain.services;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.queries.GetExaminerByIdQuery;

import java.util.Optional;

public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByIdQuery query);
}
