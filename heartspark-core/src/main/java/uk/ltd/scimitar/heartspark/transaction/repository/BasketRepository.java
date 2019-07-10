package uk.ltd.scimitar.heartspark.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.transaction.entity.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
