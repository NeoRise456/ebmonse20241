package org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.transform;

import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.resources.MentalStateExamResource;

/**
 * Assembler to convert a MentalStateExam entity to a MentalStateExamResource
 * @author Juan Astonitas
 */
public class MentalStateExamResourceFromEntityAssembler {
    /**
     * Converts a MentalStateExam entity to a MentalStateExamResource
     * @param exam
     * @return MentalStateExamResource
     * @see MentalStateExamResource
     * @see MentalStateExam
     * @author Juan Astonitas
     */
    public static MentalStateExamResource toResoruceFromEntity(MentalStateExam exam) {
        return new MentalStateExamResource(
                exam.getId(),
                exam.getPatientId(),
                exam.getExamDate(),
                exam.getOrientationScore(),
                exam.getRegistrationScore(),
                exam.getAttentionAndCalculationScore(),
                exam.getRecallScore(),
                exam.getLanguageScore(),
                exam.getExaminerNationalProviderIdentifier().examinerNationalProviderIdentifier()
        );
    }
}
