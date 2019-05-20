package uk.ltd.scimitar.heartspark.ui.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.repository.AccountRepository;
import uk.ltd.scimitar.heartspark.account.service.AccountService;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceBean implements UserDetailsService {

    private AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceBean(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
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
