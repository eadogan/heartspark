package uk.ltd.scimitar.heartspark.account.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "account_role_map",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_address", referencedColumnName = "email_address")
    private Credential credential;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Account() {
        super();
    }

    private Account(final Builder builder) {
        this.id = builder.id;
        this.roles = builder.roles;
        this.credential = builder.credential;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
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
        private String firstName;
        private String lastName;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
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
