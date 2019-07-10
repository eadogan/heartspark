package uk.ltd.scimitar.heartspark.profile.repository;

import uk.ltd.scimitar.heartspark.profile.entity.MatchedGender;

import javax.persistence.AttributeConverter;

public class MatchedGenderConverter implements AttributeConverter<MatchedGender, String> {

    @Override
    public String convertToDatabaseColumn(MatchedGender gender) {
        return gender.name();
    }

    @Override
    public MatchedGender convertToEntityAttribute(String gender) {
        return MatchedGender.valueOf(gender);
    }

}
