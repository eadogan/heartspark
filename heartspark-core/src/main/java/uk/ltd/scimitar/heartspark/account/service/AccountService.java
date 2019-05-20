package uk.ltd.scimitar.heartspark.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;

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
    public void create(final Account account) {
        account.getCredential().setPassword(bCryptPasswordEncoder.encode(account.getCredential().getPassword()));
        accountRepository.save(account);
    }

}
