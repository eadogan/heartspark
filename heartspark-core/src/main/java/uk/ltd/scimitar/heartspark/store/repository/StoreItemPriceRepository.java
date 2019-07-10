package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.StoreItemPrice;

import java.util.List;

@Repository
public interface StoreItemPriceRepository extends JpaRepository<StoreItemPrice, Long> {

    @Query("SELECT sip FROM StoreItemPrice sip INNER JOIN sip.storeItem si WHERE si.id = :storeItemId")
    List<StoreItemPrice> findByStoreItemId(@Param("storeItemId") Long storeItemId);

}
