package org.hign.platform.u202110237.ebmonse20241.assessment.application.internal.commandservices;

import org.hign.platform.u202110237.ebmonse20241.assessment.application.internal.outboundservices.ExternalExaminerService;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202110237.ebmonse20241.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

/**
 * MentalStateExamCommandServiceImpl
 * @Author Juan Astonitas
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalExaminerService externalExamierService;

    /**
     * Constructor
     * @param mentalStateExamRepository
     * @param externalExamierService
     * @author Juan Astonitas
     */
    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalExaminerService externalExamierService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalExamierService = externalExamierService;
    }


    /**
     * Handle for CreateMentalStateExamCommand
     * @param command
     * @return Long
     * @author Juan Astonitas
     */
    @Override
    public Long handle(CreateMentalStateExamCommand command) {

        if(!externalExamierService.existsExaminerByNationalProviderIdentifier(
                command.examinerNationalProviderIdentifier()
        )){
            throw new IllegalArgumentException("Examiner with national provider identifier: " + command.examinerNationalProviderIdentifier() + " does not exist");
        }

        var mentalStateExam = new MentalStateExam(command);

        try {
            this.mentalStateExamRepository.save(mentalStateExam);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving: " + e.getMessage());
        }

        return mentalStateExam.getId();
    }
}
