package uk.ltd.scimitar.heartspark.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ltd.scimitar.heartspark.store.entity.StoreItemCategory;

import java.util.List;

@Repository
public interface StoreItemCategoryRepository extends JpaRepository<StoreItemCategory, Long> {

    @Query("SELECT sic FROM StoreItemCategory sic INNER JOIN sic.store s WHERE s.id = :storeId")
    List<StoreItemCategory> findAllByStoreId(@Param("storeId") Long storeId);

}
