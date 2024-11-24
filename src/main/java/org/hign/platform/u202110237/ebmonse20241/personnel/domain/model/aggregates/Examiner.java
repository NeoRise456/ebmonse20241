package org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202110237.ebmonse20241.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "examiners")
@Getter
@NoArgsConstructor
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {


    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nationalProviderIdentifier",
                    column = @Column(
                            name = "national_provider_identifier",
                            length = 36 ,
                            nullable = false
                    )
            )
    })
    private NationalProviderIdentifier nationalProviderIdentifier;

    public Examiner(String firstName, String lastName, String nationalProviderIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = new NationalProviderIdentifier(nationalProviderIdentifier);
    }

    public Examiner(CreateExaminerCommand command){
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.nationalProviderIdentifier = new NationalProviderIdentifier(command.nationalProviderIdentifier());
    }

}
