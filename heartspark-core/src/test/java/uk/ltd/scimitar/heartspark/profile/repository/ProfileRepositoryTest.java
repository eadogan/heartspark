package uk.ltd.scimitar.heartspark.profile.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.profile.entity.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProfileRepositoryTest {

    @Autowired
    ProfileRepository underTest;

    @Sql("create_profile.sql")
    @Test
    @DisplayName("Find an account by profile id")
    void shouldFindAccountByProfileId() throws Throwable {
        final Profile profile = underTest.findById(1L).orElseThrow(Assertions::fail);
        assertEquals(1, profile.getId());
        assertEquals(2, profile.getTags().size());
        assertEquals(Gender.MALE, profile.getGender());
        assertEquals(MatchedGender.FEMALE, profile.getMatchedGender());
        assertEquals(LocalDate.of(1940, 11, 27), profile.getDateOfBirth());
        assertEquals("Bruce", profile.getProfileName());
        assertEquals("Welcome", profile.getProfileMessage());
        assertEquals("Tag line", profile.getTagLine());
        assertEquals(BodyType.MUSCULAR, profile.getBodyType());
        assertEquals(EyeColour.BROWN, profile.getEyeColour());
        assertEquals(HairColour.BROWN, profile.getHairColour());
        assertEquals(Integer.valueOf(62), profile.getWeight());
        assertEquals(Integer.valueOf(175), profile.getHeight());
        assertEquals(Ethnicity.ASIAN, profile.getEthnicity());
        assertEquals(Religion.BUDDHIST, profile.getReligion());
        assertEquals(Education.UNIVERSITY, profile.getEducation());
        assertEquals(Salary.OVER_50K, profile.getSalary());
        assertEquals(TriStateType.FALSE, profile.getSmoker());
        assertEquals(TriStateType.TRUE, profile.getDrivingLicence());
        assertEquals(TriStateType.TRUE, profile.getAlcoholDrinker());
        assertEquals(TriStateType.TRUE, profile.getChildren());
        assertEquals(TriStateType.FALSE, profile.getYoungChildren());
        assertEquals(TriStateType.TRUE, profile.getEmployed());
    }

}
