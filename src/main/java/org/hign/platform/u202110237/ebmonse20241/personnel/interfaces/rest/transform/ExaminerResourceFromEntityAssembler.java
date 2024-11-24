package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.transform;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources.ExaminerResource;

/**
 * Assembler class to convert an Examiner entity to an ExaminerResource
 * @author Juan Astonitas
 */
public class ExaminerResourceFromEntityAssembler {
    /**
     * Converts an Examiner entity to an ExaminerResource
     * @param entity
     * @return ExaminerResource
     * @author Juan Astonitas
     */
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier().nationalProviderIdentifier()
        );
    }
}
