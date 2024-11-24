package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.transform;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources.CreateExaminerResource;

/**
 * Assembler class to convert a CreateExaminerResource to a CreateExaminerCommand
 * @author Juan Astonitas
 */
public class CreateExaminerCommandFromResourceAssembler {
    /**
     * Converts a CreateExaminerResource to a CreateExaminerCommand
     * @param resource
     * @return CreateExaminerCommand
     * @author Juan Astonitas
     */
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}
