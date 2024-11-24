package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.transform;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier().nationalProviderIdentifier()
        );
    }
}
