package uk.ltd.scimitar.heartspark.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;

import java.io.Serializable;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountService implements UserDetailsService, Serializable {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String emailAddress) throws UsernameNotFoundException {
        return accountRepository.findByEmailAddress(emailAddress)
                .map(accountUserMapper)
                .orElseThrow(() -> new UsernameNotFoundException(emailAddress));
    }

    private Function<Account, User> accountUserMapper = (account) -> new User(
                account.getCredential().getEmailAddress(),
                account.getCredential().getPassword(),
                getAuthorities(account.getRoles())
            );

    private Set<GrantedAuthority> getAuthorities(final Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

}
