package uk.ltd.scimitar.heartspark.account.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    @JoinTable(
            name = "account_role_map",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_address", referencedColumnName = "email_address")
    private Credential credential;

    public Account() {
        super();
    }

    private Account(final Builder builder) {
        this.id = builder.id;
        this.roles = builder.roles;
        this.credential = builder.credential;
    }

    public Credential getCredential() {
        return credential;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean hasRole(String roleName) {
        return roles.stream().anyMatch(role -> role.getName().equals(roleName));
    }

    public static class Builder {

        private long id;
        private Set<Role> roles;
        private Credential credential;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Builder withCredential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }

}
