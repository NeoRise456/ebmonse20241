package org.hign.platform.u202110237.ebmonse20241.assessment.application.internal.queryservices;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.queries.GetMentalStateExamByIdQuery;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.services.MentalStateExamQueryService;
import org.hign.platform.u202110237.ebmonse20241.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * MentalStateExamQueryServiceImpl
 * @author Juan Astonitas
 */
@Service
public class MentalStateExamQueryServiceImpl implements MentalStateExamQueryService {

    private final MentalStateExamRepository mentalStateExamRepository;

    /**
     * Constructor
     * @param mentalStateExamRepository
     * @author Juan Astonitas
     */
    public MentalStateExamQueryServiceImpl(MentalStateExamRepository mentalStateExamRepository) {
        this.mentalStateExamRepository = mentalStateExamRepository;
    }


    /**
     * Handle for GetMentalStateExamByIdQuery
     * @param query
     * @return Optional<MentalStateExam> - Optional of MentalStateExam object
     * @author Juan Astonitas
     */
    @Override
    public Optional<MentalStateExam> handle(GetMentalStateExamByIdQuery query) {
        return mentalStateExamRepository.findById(query.mentalStateExamId());
    }
}
