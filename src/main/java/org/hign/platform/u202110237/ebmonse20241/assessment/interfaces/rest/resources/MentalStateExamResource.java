package org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.resources;

import java.util.Date;

/**
 * Resource for mental state exam
 * @param id
 * @param patientId
 * @param examDate
 * @param orientationScore
 * @param registrationScore
 * @param attentionAndCalculationScore
 * @param recallScore
 * @param languageScore
 * @param examinerNationalProviderIdentifier
 * @author Juan Astonitas
 */
public record MentalStateExamResource(
        Long id,
        Long patientId,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore,
        String examinerNationalProviderIdentifier

) {
}
