package uk.ltd.scimitar.heartspark.tag.repository;

import uk.ltd.scimitar.heartspark.tag.entity.TagType;

import javax.persistence.AttributeConverter;

public class TagTypeConverter implements AttributeConverter<TagType, String> {

    @Override
    public String convertToDatabaseColumn(TagType tagType) {
        return tagType.name();
    }

    @Override
    public TagType convertToEntityAttribute(String tagType) {
        return TagType.fromString(tagType);
    }

}
