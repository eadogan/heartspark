package uk.ltd.scimitar.heartspark.account.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.Account;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository underTest;

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Selects an account by email address")
    void shouldFindAccountByEmailAddress() {
        final Optional<Account> account = underTest.findByEmailAddress("bruce.lee@jeetkune.do");
        assertTrue(account.isPresent());

        account.ifPresent(acc -> {
            assertEquals("bruce.lee@jeetkune.do", acc.getCredential().getEmailAddress());
            assertTrue(acc.getRoles().stream()
                    .anyMatch(role -> role.getName().equals("USER")));
        });
    }

}
