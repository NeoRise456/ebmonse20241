package org.hign.platform.u202110237.ebmonse20241.assessment.application.internal.outboundservices;

import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

/**
 * ExternalExaminerService
 * @Author Juan Astonitas
 */
@Service
public class ExternalExaminerService {

    private final ExaminerContextFacade examinerContextFacade;

    /**
     * ExternalExaminerService
     * @param examinerContextFacade
     * @author Juan Astonitas
     */
    public ExternalExaminerService(ExaminerContextFacade examinerContextFacade) {
        this.examinerContextFacade = examinerContextFacade;
    }

    /**
     * existsExaminerByNationalProviderIdentifier
     * @param nationalProviderIdentifier
     * @return boolean
     * @author Juan Astonitas
     */
    public boolean existsExaminerByNationalProviderIdentifier(String nationalProviderIdentifier) {
        return examinerContextFacade.existsExaminerByNationalProviderIdentifier(nationalProviderIdentifier);
    }



}
