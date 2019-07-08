package uk.ltd.scimitar.heartspark.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
