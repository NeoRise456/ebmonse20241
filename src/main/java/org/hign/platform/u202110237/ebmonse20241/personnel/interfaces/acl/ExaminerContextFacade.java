package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.acl;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifier;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerQueryService;

public class ExaminerContextFacade {

    private final ExaminerQueryService examinerQueryService;

    public ExaminerContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    public boolean existsExaminerByNationalProviderIdentifier(String nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifier = new GetExaminerByNationalProviderIdentifier(nationalProviderIdentifier);

        return examinerQueryService.handle(getExaminerByNationalProviderIdentifier).isPresent();
    }
}
