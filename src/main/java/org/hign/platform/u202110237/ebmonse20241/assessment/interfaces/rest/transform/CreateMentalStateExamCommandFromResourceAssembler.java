package org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.transform;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.resources.CreateMentalStateExamResource;

/**
 * Assembler to convert a CreateMentalStateExamResource to a CreateMentalStateExamCommand
 * @see CreateMentalStateExamResource
 * @see CreateMentalStateExamCommand
 * @author Juan Astonitas
 */
public class CreateMentalStateExamCommandFromResourceAssembler {
    /**
     * Converts a CreateMentalStateExamResource to a CreateMentalStateExamCommand
     * @param resource
     * @return CreateMentalStateExamCommand
     * @see CreateMentalStateExamResource
     * @see CreateMentalStateExamCommand
     * @author Juan Astonitas
     */
    public static CreateMentalStateExamCommand toCommandFromResoruce(CreateMentalStateExamResource resource){
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examDate(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore(),
                resource.examinerNationalProviderIdentifier()
        );
    }
}
