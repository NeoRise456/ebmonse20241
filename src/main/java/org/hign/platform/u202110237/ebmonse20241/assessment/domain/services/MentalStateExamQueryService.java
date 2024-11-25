package org.hign.platform.u202110237.ebmonse20241.assessment.domain.services;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.queries.GetMentalStateExamByIdQuery;

import java.util.Optional;

/**
 * MentalStateExamQueryService
 * @author Juan Astonitas
 */
public interface MentalStateExamQueryService {
    Optional<MentalStateExam> handle(GetMentalStateExamByIdQuery query);
}
