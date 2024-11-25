package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.acl;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifier;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerQueryService;
import org.springframework.stereotype.Service;

/**
 * ExaminerContextFacade
 * @author Juan Astonitas
 */
@Service
public class ExaminerContextFacade {

    private final ExaminerQueryService examinerQueryService;

    /**
     * Constructor
     * @param examinerQueryService
     * @author Juan Astonitas
     */
    public ExaminerContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    /**
     * existsExaminerByNationalProviderIdentifier
     * @param nationalProviderIdentifier
     * @return boolean
     * @author Juan Astonitas
     */
    public boolean existsExaminerByNationalProviderIdentifier(String nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifier = new GetExaminerByNationalProviderIdentifier(nationalProviderIdentifier);

        return examinerQueryService.handle(getExaminerByNationalProviderIdentifier).isPresent();
    }

}
