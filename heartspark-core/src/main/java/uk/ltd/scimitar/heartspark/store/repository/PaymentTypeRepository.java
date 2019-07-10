package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.PaymentType;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, String> {
}
