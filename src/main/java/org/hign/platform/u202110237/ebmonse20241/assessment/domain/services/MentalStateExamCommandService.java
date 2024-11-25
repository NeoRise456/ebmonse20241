package org.hign.platform.u202110237.ebmonse20241.assessment.domain.services;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands.CreateMentalStateExamCommand;

/**
 * MentalStateExamCommandService
 * @author Juan Astonitas
 */
public interface MentalStateExamCommandService {
    Long handle(CreateMentalStateExamCommand command);
}
