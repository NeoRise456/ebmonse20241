package org.hign.platform.u202110237.ebmonse20241.personnel.domain.services;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

/**
 * Service for handling examiner commands
 * @author Juan Astonitas
 */
public interface ExaminerCommandService {
    Long handle(CreateExaminerCommand command);
}
