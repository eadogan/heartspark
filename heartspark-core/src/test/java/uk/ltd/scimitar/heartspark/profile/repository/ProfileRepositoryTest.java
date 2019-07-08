package uk.ltd.scimitar.heartspark.profile.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProfileRepositoryTest {

    @Autowired
    ProfileRepository underTest;

    @Sql("create_profile.sql")
    @Test
    @DisplayName("Find an account by profile id")
    void shouldFindAccountByProfileId() {
        Optional<Profile> profileOpt = underTest.findById(1L);
        assertTrue(profileOpt.isPresent());
    }

}
