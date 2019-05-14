package uk.ltd.scimitar.heartspark.account.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

    public Role() {
        super();
    }

    private Role(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.accounts = builder.accounts;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private long id;
        private String name;
        private Set<Account> accounts;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
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
