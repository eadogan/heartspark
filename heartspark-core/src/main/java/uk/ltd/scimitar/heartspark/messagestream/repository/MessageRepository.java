package uk.ltd.scimitar.heartspark.messagestream.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.messagestream.entity.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m INNER JOIN m.sourceProfile sp WHERE sp.id = :profileId")
    List<Message> findAllBySender(@Param("profileId") Long profileId, Pageable pageable);

}
