package uk.ltd.scimitar.heartspark.account.repository;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.account.entity.Role;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRoleRepositoryTest {

    @Autowired
    AccountRoleRepository underTest;

    @Test
    @DisplayName("Finds all roles")
    void shouldFindAllRoles() {
        final List<Role> roles = underTest.findAll();
        assertEquals(2, roles.size());
        assertThat(roles, containsInAnyOrder(Role.builder().name("USER").build(),
                Role.builder().name("ADMINISTRATOR").build()));
    }

}
