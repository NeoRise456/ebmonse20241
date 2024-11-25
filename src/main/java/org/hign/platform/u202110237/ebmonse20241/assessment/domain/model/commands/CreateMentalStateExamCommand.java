package org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands;

/**
 * Command to create a mental state exam
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
public record CreateMentalStateExamCommand(
        Long patientId,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore,
        String examinerNationalProviderIdentifier
) {
}
