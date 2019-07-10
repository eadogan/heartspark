package uk.ltd.scimitar.heartspark.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.account.entity.Credential;

import java.util.Optional;

@Repository
public interface AccountCredentialRepository extends JpaRepository<Credential, String> {

    @Query("SELECT c FROM Credential c WHERE c.emailAddress = :emailAddress AND c.password = :password")
    Optional<Credential> findByEmailAddressAndPassword(@Param("emailAddress") String emailAddress,
                                                       @Param("password") String password);

}
