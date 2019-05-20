package uk.ltd.scimitar.heartspark.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credential {

    @Id
    @Column(name = "email_address")
    private String emailAddress;
    private String password;
    @OneToOne(mappedBy = "credential")
    private Account account;

    public Credential() {
        super();
    }

    private Credential(final Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.account = builder.account;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public static class Builder {

        private String emailAddress;
        private String password;
        private Account account;

        public Builder(String emailAddress,
                       String password) {
            this.emailAddress = emailAddress;
            this.password = password;
        }

        public Builder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public Credential build() {
            return new Credential(this);
        }

    }

}
