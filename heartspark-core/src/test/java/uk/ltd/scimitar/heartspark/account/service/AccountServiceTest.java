package uk.ltd.scimitar.heartspark.account.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uk.ltd.scimitar.heartspark.account.entity.*;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

import java.sql.Date;
import java.time.Instant;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountRepository mockAccountRepository;

    @Mock
    BCryptPasswordEncoder mockBCryptPasswordEncoder;

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
                .anyMatch(role -> role.getRoleType().equals(RoleType.USER)));
    }

    @Test
    @DisplayName("Creates a new account from Registration object")
    void shouldCreateAccount() {
        final Account account = Account.builder()
                .roles(Set.of(Role.builder().roleType(RoleType.USER).build()))
                .credential(Credential.builder()
                        .emailAddress("bruce.lee@jeetkune.do")
                        .password("lindalee")
                        .build())
                .firstName("Bruce")
                .acceptedTermsAndConditions(true)
                .postalCode("98101")
                .credit(Credit.builder().tokens(5000).build())
                .profile(Profile.builder()
                        .createdAt(Date.from(Instant.now()))
                        .updatedAt(Date.from(Instant.now()))
                        .build())
                .createdAt(Date.from(Instant.now()))
                .updatedAt(Date.from(Instant.now()))
                .build();

        when(mockBCryptPasswordEncoder.encode(anyString())).thenReturn("encoded_password");
        when(mockAccountRepository.save(any(Account.class))).thenReturn(new Account());

        underTest.create(account);

        final ArgumentCaptor<Account> argCaptor = ArgumentCaptor.forClass(Account.class);
        verify(mockAccountRepository).save(argCaptor.capture());

        assertEquals("bruce.lee@jeetkune.do", argCaptor.getValue().getCredential().getEmailAddress());
        assertEquals("encoded_password", argCaptor.getValue().getCredential().getPassword());
        assertTrue(argCaptor.getValue().getRoles().contains(Role.builder().roleType(RoleType.USER).build()));
        assertEquals(true, argCaptor.getValue().getAcceptedTermsAndConditions());
        assertEquals(Locale.UK, argCaptor.getValue().getCountry());
        assertEquals("Bruce", argCaptor.getValue().getFirstName());
        assertEquals("98101", argCaptor.getValue().getPostalCode(), "98101");
        assertEquals(Integer.valueOf(5000), argCaptor.getValue().getCredit().getTokens());
    }

    private Account validAccount() {
        return Account.builder()
                .id(1L)
                .credential(Credential.builder()
                        .emailAddress("chuck.norris@karate.com")
                        .password("password")
                        .build())
                .roles(Set.of(Role.builder()
                        .roleType(RoleType.USER)
                        .build()))
                .build();
    }

}
