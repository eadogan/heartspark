package uk.ltd.scimitar.heartspark.profile.repository;

import uk.ltd.scimitar.heartspark.profile.entity.TriStateType;

import javax.persistence.AttributeConverter;

public class TriStateTypeConverter implements AttributeConverter<TriStateType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TriStateType triStateType) {
        if (triStateType == null)
            return 0;

        switch (triStateType) {
            case TRUE:
                return 1;
            case FALSE:
                return 2;
            case UNSPECIFIED:
                return 0;
        }

        return 0;
    }

    @Override
    public TriStateType convertToEntityAttribute(Integer type) {
        if (type == null)
            return TriStateType.UNSPECIFIED;
        switch (type) {
            case 0:
                return TriStateType.UNSPECIFIED;
            case 1:
                return TriStateType.TRUE;
            case 2:
                return TriStateType.FALSE;
        }
        return TriStateType.UNSPECIFIED;
    }

}
