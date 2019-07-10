package uk.ltd.scimitar.heartspark.account.repository;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.Credential;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountCredentialRepositoryTest {

    @Autowired
    AccountCredentialRepository underTest;

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Finds a credential by email address and password")
    void shouldFindCredentialByEmailAddressAndPassword() throws Throwable {
        final Credential credential = underTest.findByEmailAddressAndPassword("bruce.lee@jeetkune.do",
                "password").orElseThrow(() -> fail("Expected to find a credential but none found."));
        assertEquals("bruce.lee@jeetkune.do", credential.getEmailAddress());
        assertEquals("password", credential.getPassword());
        assertNotNull(credential.getAccount());
    }

}
