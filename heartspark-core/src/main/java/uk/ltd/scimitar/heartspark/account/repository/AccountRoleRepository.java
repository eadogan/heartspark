package uk.ltd.scimitar.heartspark.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.account.entity.Role;

@Repository
public interface AccountRoleRepository extends JpaRepository<Role, String> {
}
