package org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands;

public record CreateExaminerCommand(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
