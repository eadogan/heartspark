package uk.ltd.scimitar.heartspark.account.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Credential;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
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

        UserDetails userDetails = underTest.loadUserByUsername(username);
        assertEquals("chuck.norris@karate.com", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("USER")));
    }

    @Test
    @DisplayName("Throws exception when the given username cannot be found")
    void shouldThrowExceptionWhenNameNotFound() {
        final String username = "chuck.norris@karate.com";

        when(mockAccountRepository.findByEmailAddress(username))
                .thenReturn(Optional.empty());

        UsernameNotFoundException thrown =
                assertThrows(UsernameNotFoundException.class,
                        () -> underTest.loadUserByUsername(username));

        assertEquals(username, thrown.getMessage());
    }

    private Account validAccount() {
        return new Account.Builder()
                .withId(1L)
                .withCredential(new Credential.Builder("chuck.norris@karate.com", "password").build())
                .withRoles(Set.of(new Role.Builder("USER").build()))
                .build();
    }

}
