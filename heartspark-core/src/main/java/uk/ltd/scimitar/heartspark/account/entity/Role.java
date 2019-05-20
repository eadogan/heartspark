package uk.ltd.scimitar.heartspark.account.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public Role() {
        super();
    }

    private Role(final Builder builder) {
        this.name = builder.name;
        this.accounts = builder.accounts;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private String name;
        private Set<Account> accounts;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withAccounts(Set<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Role build() {
            return new Role(this);
        }

    }

}
