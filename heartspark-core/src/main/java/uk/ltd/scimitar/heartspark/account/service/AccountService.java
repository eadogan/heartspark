package uk.ltd.scimitar.heartspark.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
    public Optional<Account> create(final Account account) {
        account.setRoles(Set.of(Role.builder().name("USER").build()));
        account.setCountry(Locale.UK);
        account.getCredential().setPassword(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()));
        return Optional.of(accountRepository.save(account));
    }

}
