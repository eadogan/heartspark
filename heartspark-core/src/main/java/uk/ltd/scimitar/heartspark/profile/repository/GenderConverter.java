package uk.ltd.scimitar.heartspark.profile.repository;

import uk.ltd.scimitar.heartspark.profile.entity.Gender;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.name();
    }

    @Override
    public Gender convertToEntityAttribute(String gender) {
        return Gender.valueOf(gender);
    }

}
