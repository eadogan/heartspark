package uk.ltd.scimitar.heartspark.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.account.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a INNER JOIN a.credential c WHERE c.emailAddress = :emailAddress")
    Optional<Account> findByEmailAddress(@Param("emailAddress") String emailAddress);

}
