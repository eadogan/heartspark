package uk.ltd.scimitar.heartspark.account.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Credential;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

import java.sql.Date;
import java.time.Instant;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository underTest;

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Find an account by email address")
    void shouldFindAccountByEmailAddress() {
        final Optional<Account> account = underTest.findByEmailAddress("bruce.lee@jeetkune.do");
        assertTrue(account.isPresent());

        account.ifPresent(acc -> {
            assertEquals("bruce.lee@jeetkune.do", acc.getCredential().getEmailAddress());
            assertTrue(acc.getRoles().stream()
                    .anyMatch(role -> role.getName().equals("USER")));
            assertEquals("Bruce", acc.getFirstName());
            assertEquals(true, acc.getAcceptedTermsAndConditions());
            assertEquals("98101", acc.getPostalCode());
            assertEquals(Locale.US, acc.getCountry());
            assertEquals(1L, acc.getProfile().getId());
        });
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
        final Account account = Account.builder()
                .roles(Set.of(Role.builder().name("USER").build()))
                .credential(Credential.builder()
                        .emailAddress("bruce.lee@jeetkune.do")
                        .password("lindalee")
                        .build())
                .firstName("Bruce")
                .acceptedTermsAndConditions(true)
                .country(Locale.US)
                .postalCode("98101")
                .profile(Profile.builder()
                        .createdAt(Date.from(Instant.now()))
                        .updatedAt(Date.from(Instant.now()))
                        .build())
                .createdAt(Date.from(Instant.now()))
                .updatedAt(Date.from(Instant.now()))
                .build();
        final Account savedAccount = underTest.save(account);
        assertTrue(savedAccount.getId() > 0);
    }

}
