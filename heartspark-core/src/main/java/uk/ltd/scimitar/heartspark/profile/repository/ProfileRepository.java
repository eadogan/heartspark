package uk.ltd.scimitar.heartspark.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
