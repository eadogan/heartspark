package uk.ltd.scimitar.heartspark.util.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class LocaleConverterTest {

    private LocaleConverter underTest = new LocaleConverter();

    @Test
    @DisplayName("Convert a Locale object to a string to store in database")
    void shouldConvertLocaleToDatabaseColumn() {
        assertEquals("en-GB", underTest.convertToDatabaseColumn(Locale.UK));
    }

    @Test
    @DisplayName("Returns default locale when passed null Locale object")
    void shouldReturnDefaultLocaleWhenParamIsNull() {
        assertEquals(LocaleConverter.DEFAULT_LOCALE.toLanguageTag(), underTest.convertToDatabaseColumn(null));
    }

    @Test
    @DisplayName("Convert a language tag string to a Locale object")
    void shouldConvertLanguageTagToLocale() {
        assertEquals(Locale.US, underTest.convertToEntityAttribute("en-US"));
    }

    @Test
    @DisplayName("Returns default locale when passed null language tag")
    void shouldReturnDefaultLocaleWhenLanguageTagIsNull() {
        assertEquals(LocaleConverter.DEFAULT_LOCALE, underTest.convertToEntityAttribute(null));
    }

    @Test
    @DisplayName("Returns default locale when passed empty language tag")
    void shouldReturnDefaultLocaleWhenLanguageTagIsEmpty() {
        assertEquals(LocaleConverter.DEFAULT_LOCALE, underTest.convertToEntityAttribute(""));
    }

}
