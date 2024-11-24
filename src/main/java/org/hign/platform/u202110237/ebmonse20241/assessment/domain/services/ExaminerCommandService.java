package org.hign.platform.u202110237.ebmonse20241.assessment.domain.services;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {
    Optional<Long> handle(CreateExaminerCommand command);
}
