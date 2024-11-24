package org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands;

/**
 * Command to create an examiner
 * @param firstName
 * @param lastName
 * @param nationalProviderIdentifier
 * @author Juan Astonitas
 */
public record CreateExaminerCommand(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
