package org.hign.platform.u202110237.ebmonse20241.personnel.application.internal.queryservices;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202110237.ebmonse20241.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;

import java.util.Optional;

public class ExaminerQueryServiceImpl implements ExaminerQueryService {

    private final ExaminerRepository examinerRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(GetExaminerByIdQuery query) {
        return examinerRepository.findById(query.examinerId());
    }
}
