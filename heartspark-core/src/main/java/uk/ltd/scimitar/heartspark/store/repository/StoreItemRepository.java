package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.StoreItem;

@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
}
