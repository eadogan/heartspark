package uk.ltd.scimitar.heartspark.account.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.*;
import uk.ltd.scimitar.heartspark.profile.entity.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountCreditRepository creditRepository;

    @Autowired
    AccountRepository underTest;

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Find an account by email address")
    void shouldFindAccountByEmailAddress() throws Throwable {
        final Account account = underTest.findByEmailAddress("bruce.lee@jeetkune.do").orElseThrow(()
                -> Assertions.fail("Expected account but none found."));
        assertEquals("bruce.lee@jeetkune.do", account.getCredential().getEmailAddress());
        assertTrue(account.getRoles().stream()
                .anyMatch(role -> role.getRoleType().equals(RoleType.USER)));
        assertEquals("Bruce", account.getFirstName());
        assertEquals(true, account.getAcceptedTermsAndConditions());
        assertEquals("98101", account.getPostalCode());
        assertEquals(Locale.US, account.getCountry());
        assertEquals(1L, account.getProfile().getId());
        assertEquals(Unit.METRIC, account.getPreferredUnit());
    }

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Does not return account when using email that does not exist")
    void shouldNotReturnAccountWhenNoMatchingEmailAddress() {
        final Optional<Account> account = underTest.findByEmailAddress("bruce.lee-old@jeetkune.do");
        assertFalse(account.isPresent());
    }

    @Test
    @DisplayName("Saves a new account")
    void shouldSaveNewAccount() {
        final Credit credit = creditRepository.save(Credit.builder()
                .tokens(5000)
                .createdAt(Date.from(Instant.now()))
                .updatedAt(Date.from(Instant.now()))
                .build());
        final Account account = Account.builder()
                .roles(Set.of(Role.builder().roleType(RoleType.USER).build()))
                .credential(Credential.builder()
                        .emailAddress("bruce.lee@jeetkune.do")
                        .password("lindalee")
                        .build())
                .firstName("Bruce")
                .acceptedTermsAndConditions(true)
                .country(Locale.US)
                .postalCode("98101")
                .credit(credit)
                .profile(Profile.builder()
                        .profileName("Bruce")
                        .bodyType(BodyType.MUSCULAR)
                        .eyeColour(EyeColour.BROWN)
                        .education(Education.OPEN_UNIVERSITY)
                        .hairColour(HairColour.BROWN)
                        .ethnicity(Ethnicity.ASIAN)
                        .religion(Religion.BUDDHIST)
                        .salary(Salary.UNSPECIFIED)
                        .gender(Gender.MALE)
                        .matchedGender(MatchedGender.FEMALE)
                        .dateOfBirth(LocalDate.of(1940, 11, 27))
                        .createdAt(Date.from(Instant.now()))
                        .updatedAt(Date.from(Instant.now()))
                        .build())
                .preferredUnit(Unit.IMPERIAL)
                .createdAt(Date.from(Instant.now()))
                .updatedAt(Date.from(Instant.now()))
                .build();
        final Account savedAccount = underTest.save(account);
        assertTrue(savedAccount.getId() > 0);
    }

}
