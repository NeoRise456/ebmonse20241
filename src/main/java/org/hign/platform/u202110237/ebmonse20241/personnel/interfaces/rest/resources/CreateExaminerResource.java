package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources;

/**
 * Resource class for creating an examiner
 * @param firstName
 * @param lastName
 * @param nationalProviderIdentifier
 * @author Juan Astonitas
 */
public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
