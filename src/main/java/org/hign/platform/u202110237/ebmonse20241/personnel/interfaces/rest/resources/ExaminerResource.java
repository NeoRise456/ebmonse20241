package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources;

public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
