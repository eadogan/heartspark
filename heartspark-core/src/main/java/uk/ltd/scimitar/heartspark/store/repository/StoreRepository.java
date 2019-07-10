package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
