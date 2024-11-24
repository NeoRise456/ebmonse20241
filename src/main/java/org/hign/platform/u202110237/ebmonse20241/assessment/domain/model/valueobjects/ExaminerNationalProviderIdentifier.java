package org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.valueobjects;

public record ExaminerNationalProviderIdentifier(String examinerNationalProviderIdentifier) {

    public ExaminerNationalProviderIdentifier {
        if (examinerNationalProviderIdentifier == null || examinerNationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("Examiner National Provider Identifier cannot be null or blank");
        }
        if (examinerNationalProviderIdentifier.length() != 36) {
            throw new IllegalArgumentException("Examiner National Provider Identifier must be 36 characters long");
        }
        if (!examinerNationalProviderIdentifier.matches("[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}")) {
            throw new IllegalArgumentException("Examiner National Provider Identifier must be a valid UUID");
        }

    }
}
