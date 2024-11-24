package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources;

/**
 * Resource class for an examiner
 * @param id
 * @param firstName
 * @param lastName
 * @param nationalProviderIdentifier
 * @author Juan Astonitas
 */
public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
