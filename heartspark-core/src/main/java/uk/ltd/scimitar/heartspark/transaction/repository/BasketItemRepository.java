package uk.ltd.scimitar.heartspark.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.transaction.entity.BasketItem;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
}
