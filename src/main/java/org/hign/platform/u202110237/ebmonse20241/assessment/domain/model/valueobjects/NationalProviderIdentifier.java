package org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.valueobjects;


public record NationalProviderIdentifier(String nationalProviderIdentifier) {

    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null or blank");
        }
        if (nationalProviderIdentifier.length() != 36) {
            throw new IllegalArgumentException("National Provider Identifier must be 36 characters long");
        }
        if (!nationalProviderIdentifier.matches("[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}")) {
            throw new IllegalArgumentException("National Provider Identifier must be a valid UUID");
        }

    }

}
