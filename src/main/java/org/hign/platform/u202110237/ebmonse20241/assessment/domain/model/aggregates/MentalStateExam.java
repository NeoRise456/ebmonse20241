package org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202110237.ebmonse20241.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * MentalStateExam
 * @author Juan Astonitas
 */
@Entity
@Table(name = "mental_state_exams")
@Getter
@NoArgsConstructor
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {
    @NotNull
    @NotBlank
    private Long patientId;

    @NotNull
    @NotBlank
    private Date examDate;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer orientationScore;

    @NotNull
    @Min(0)
    @Max(3)
    private Integer registrationScore;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer attentionAndCalculationScore;

    @NotNull
    @Min(0)
    @Max(3)
    private Integer recallScore;

    @NotNull
    @Min(0)
    @Max(9)
    private Integer languageScore;

    //TODO: do one-to-many relationship with the mental state exam (nationalProviderIdentifier)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "examinerNationalProviderIdentifier",
                    column = @Column(
                            name = "examiner_national_provider_identifier",
                            length = 36 ,
                            nullable = false
                    )
            )
    })
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;

    public MentalStateExam(CreateMentalStateExamCommand command) {
        this.patientId = command.patientId();
        this.examDate = convertStringToDate(command.examDate());
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier());
    }

    public static Date convertStringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
