package uk.ltd.scimitar.heartspark.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Credential;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;
import uk.ltd.scimitar.heartspark.ui.domain.Registration;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService implements Serializable {

    private AccountRepository accountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountService(final AccountRepository accountRepository,
                          final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public Optional<Account> findByEmailAddress(final String emailAddress) {
        return accountRepository.findByEmailAddress(emailAddress);
    }

    @Transactional
    public Optional<Account> create(final Registration registration) {
        final String generatedPassword = "password";
        registration.setPassword(generatedPassword);

        return create(Account.builder()
                .firstName(registration.getGivenName())
                .roles(Set.of(Role.builder()
                        .name("USER")
                        .build()))
                .credential(Credential.builder()
                        .emailAddress(registration.getEmailAddress())
                        .password(registration.getPassword())
                        .build())
                .firstName(registration.getGivenName())
                .postalCode(registration.getPostalCode())
                .country(registration.getCountry())
                .acceptedTermsAndConditions(registration.getTermsAndConditions())
                .profile(Profile.builder().build())
                .build());
    }

    @Transactional
    public Optional<Account> create(final Account account) {
        account.getCredential().setPassword(bCryptPasswordEncoder.encode(account.getCredential().getPassword()));
        return Optional.of(accountRepository.save(account));
    }

}
