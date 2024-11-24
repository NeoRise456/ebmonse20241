package org.hign.platform.u202110237.ebmonse20241.personnel.application.internal.commandservices;

import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202110237.ebmonse20241.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of the ExaminerCommandService interface.
 * @author Juan Astonitas
 */
@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    /**
     * Constructor of the class.
     * @param examinerRepository
     * @author Juan Astonitas
     */
    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Method to handle the creation of an examiner.
     * @param command
     * @return the id of the created examiner
     * @author Juan Astonitas
     */
    @Override
    public Long handle(CreateExaminerCommand command) {

        if(this.examinerRepository.existsByNationalProviderIdentifier(
            new NationalProviderIdentifier(command.nationalProviderIdentifier() ))) {

            throw new IllegalArgumentException("National provider identifier already in database.");
        }

        var examiner = new Examiner(command);

        try {
            this.examinerRepository.save(examiner);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Error while saving examiner: " + e.getMessage());
        }

        return examiner.getId();
    }
}
