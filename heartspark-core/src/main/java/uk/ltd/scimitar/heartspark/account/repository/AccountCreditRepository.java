package uk.ltd.scimitar.heartspark.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.account.entity.Credit;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountCreditRepository extends JpaRepository<Credit, Long> {

    @Query("SELECT c FROM Credit c INNER JOIN c.account a WHERE a.id = :accountId")
    Optional<Credit> findByAccountId(@Param("accountId") Long accountId);

}
