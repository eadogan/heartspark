package uk.ltd.scimitar.heartspark.profile.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.profile.entity.Gender;
import uk.ltd.scimitar.heartspark.profile.entity.MatchedGender;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

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
    }

}
