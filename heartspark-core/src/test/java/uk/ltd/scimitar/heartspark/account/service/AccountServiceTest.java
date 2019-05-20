package uk.ltd.scimitar.heartspark.account.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Credential;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountRepository mockAccountRepository;

    @InjectMocks
    AccountService underTest;

    @Test
    @DisplayName("Locates a user from the given username")
    void shouldLoadByUsername() {
        final String username = "chuck.norris@karate.com";

        when(mockAccountRepository.findByEmailAddress(username))
                .thenReturn(Optional.of(validAccount()));

        Optional<Account> account = underTest.findByEmailAddress(username);
        assertTrue(account.isPresent());

        assertEquals("chuck.norris@karate.com", account.get().getCredential().getEmailAddress());
        assertEquals("password", account.get().getCredential().getPassword());
        assertTrue(account.get().getRoles().stream()
                .anyMatch(role -> role.getName().equals("USER")));
    }

    private Account validAccount() {
        return new Account.Builder()
                .withId(1L)
                .withCredential(new Credential.Builder("chuck.norris@karate.com", "password").build())
                .withRoles(Set.of(new Role.Builder("USER").build()))
                .build();
    }

}
