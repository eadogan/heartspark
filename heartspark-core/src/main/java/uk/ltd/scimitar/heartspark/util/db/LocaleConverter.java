package uk.ltd.scimitar.heartspark.util.db;

import javax.persistence.AttributeConverter;
import java.util.Locale;

public class LocaleConverter implements AttributeConverter<Locale, String> {

    static final Locale DEFAULT_LOCALE = Locale.getDefault();

    @Override
    public String convertToDatabaseColumn(final Locale locale) {
        if (locale != null) {
            return locale.toLanguageTag();
        }
        return DEFAULT_LOCALE.toLanguageTag();
    }

    @Override
    public Locale convertToEntityAttribute(final String localeString) {
        if (localeString != null && !localeString.isEmpty()) {
            return Locale.forLanguageTag(localeString);
        }
        return DEFAULT_LOCALE;
    }

}
