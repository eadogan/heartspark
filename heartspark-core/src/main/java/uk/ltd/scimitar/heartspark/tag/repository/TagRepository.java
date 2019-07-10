package uk.ltd.scimitar.heartspark.tag.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.tag.entity.Tag;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Page<Tag> findByProfileId(Long profileId, Pageable pageable);

    Optional<Tag> findByIdAndProfileId(Long id, Long profileId);

}
