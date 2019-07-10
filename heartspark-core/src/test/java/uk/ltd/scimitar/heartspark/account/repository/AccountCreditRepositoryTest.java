package uk.ltd.scimitar.heartspark.account.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.Credit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountCreditRepositoryTest {

    @Autowired
    AccountCreditRepository underTest;

    @Sql("create_accounts.sql")
    @Test
    @DisplayName("Finds account credit by account id")
    void shouldFindAccountCreditByAccountId() throws Throwable {
        final Credit credit = underTest.findByAccountId(1L).orElseThrow(Assertions::fail);
        assertEquals(1, credit.getId());
        assertEquals(Integer.valueOf(5000), credit.getTokens());
        assertNotNull(credit.getAccount());
    }

}
