package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.CurrencyType;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, String> {
}
