package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources;

public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
