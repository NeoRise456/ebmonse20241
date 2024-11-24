package org.hign.platform.u202110237.ebmonse20241.personnel.application.internal.queryservices;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202110237.ebmonse20241.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service that handles the query to get an examiner by id
 * @author Juan Astonitas
 */
@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {

    private final ExaminerRepository examinerRepository;

    /**
     * Constructor
     * @param examinerRepository
     * @author Juan Astonitas
     */
    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Method that handles the query to get an examiner by id
     * @param query
     * @return Optional<Examiner> - the examiner found by id or empty if not found
     * @author Juan Astonitas
     */
    @Override
    public Optional<Examiner> handle(GetExaminerByIdQuery query) {
        return examinerRepository.findById(query.examinerId());
    }
}
